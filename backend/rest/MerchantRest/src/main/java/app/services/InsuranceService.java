package app.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.commons.Consts;
import app.model.Insurance;
import app.model.InsuredAmount;
import app.model.RealestateInsPackage;
import app.model.Region;
import app.model.Sport;
import app.repository.InsuranceRepository;
import app.repository.InsuredAmountRepository;
import app.repository.RealestatePackRepository;
import app.repository.RegionRepository;
import app.repository.SportRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private InsuredAmountRepository insuredAmountRepository;

	@Autowired
	private RealestatePackRepository realEstatePackRepository;

	public static final int JMBG_OK = 0;
	public static final int JMBG_INVALID = 1;
	public static final int JMBG_WARNING = 2;
	private static Pattern jmbgPattern = Pattern.compile("\\d{13}");
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

	private static final Logger logger = Logger.getLogger(InsuranceService.class);

	public Map<String, Object> create(Insurance insurance) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance successfully created");
		response.put("insurance", insurance);

		logger.info("Insurance successfully created");

		return response;
	}

	public List<Insurance> findAll() {

		return insuranceRepository.findAll();
	}

	public Insurance findById(String insId) {
		
		if (insId == null) {
			throw new BadRequestException("insuranceId is null");
		}
		
		Insurance insurance = insuranceRepository.findOne(insId);
		if (insurance == null) {
			throw new NotFoundException("Insurance with id " + insId + " doesn't exist.");
		}

		return insurance;
	}

	public String remove(String insId) {
		
		if (insId == null) {
			throw new BadRequestException("insurance id is null");
		}
		
		logger.info("Removing insurance with id: " + insId);
		insuranceRepository.delete(insId);
		return "removed";
	}

	public Map<String, Object> edit(Insurance insurance) {
		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance successfully updated");
		response.put("insurance", insurance);
		logger.info("Insurance successfully updated");
		return response;
	}

	// validacija jmbg

	public boolean checkJmbg(String jmbg, boolean withChecksum) {
		if (jmbg == null)
			return false;
		Matcher matcher = jmbgPattern.matcher(jmbg);
		if (!matcher.matches())
			return false;
		if (extractDateFromJmbg(jmbg) == null)
			return false;
		if (withChecksum && !jmbgChecksum(jmbg))
			return false;
		return true;
	}

	public static int checkJmbgWithWarning(String jmbg) {
		if (jmbg == null)
			return Consts.JMBG_INVALID;
		Matcher matcher = jmbgPattern.matcher(jmbg);
		if (!matcher.matches())
			return Consts.JMBG_INVALID;
		if (extractDateFromJmbg(jmbg) == null)
			return Consts.JMBG_INVALID;

		return jmbgChecksumWithWarning(jmbg);
	}

	/**
	 * Vadi datum iz JMBG broja. Vraca null ako datum nije ispravan.
	 * 
	 * @param jmbg
	 * @return
	 */
	private static Date extractDateFromJmbg(String jmbg) {
		String dateStr = jmbg.substring(0, 7);
		char extraDigit;
		switch (dateStr.charAt(4)) {
		case '0':
			extraDigit = '2';
			break;
		case '9':
			extraDigit = '1';
			break;
		default:
			return null;
		}
		dateStr = dateStr.substring(0, 4) + extraDigit + dateStr.substring(4);
		Date result = null;
		try {
			sdf.setLenient(false);
			result = sdf.parse(dateStr);
		} catch (ParseException ex) {
			return null;
		}
		return result;
	}

	public static int jmbgChecksumWithWarning(String jmbg) {
		int a = char2int(jmbg.charAt(0));
		int b = char2int(jmbg.charAt(1));
		int c = char2int(jmbg.charAt(2));
		int d = char2int(jmbg.charAt(3));
		int e = char2int(jmbg.charAt(4));
		int f = char2int(jmbg.charAt(5));
		int g = char2int(jmbg.charAt(6));
		int h = char2int(jmbg.charAt(7));
		int i = char2int(jmbg.charAt(8));
		int j = char2int(jmbg.charAt(9));
		int k = char2int(jmbg.charAt(10));
		int l = char2int(jmbg.charAt(11));
		int m = char2int(jmbg.charAt(12));

		int check = 11 - (7 * (a + g) + 6 * (b + h) + 5 * (c + i) + 4 * (d + j) + 3 * (e + k) + 2 * (f + l)) % 11;
		if (check > 9)
			check = 0;

		if (h != 6)
			return m == check ? Consts.JMBG_OK : Consts.JMBG_INVALID;
		else
			return m == check ? Consts.JMBG_OK : Consts.JMBG_WARNING;
	}

	private static boolean jmbgChecksum(String jmbg) {
		int a = char2int(jmbg.charAt(0));
		int b = char2int(jmbg.charAt(1));
		int c = char2int(jmbg.charAt(2));
		int d = char2int(jmbg.charAt(3));
		int e = char2int(jmbg.charAt(4));
		int f = char2int(jmbg.charAt(5));
		int g = char2int(jmbg.charAt(6));
		int h = char2int(jmbg.charAt(7));
		int i = char2int(jmbg.charAt(8));
		int j = char2int(jmbg.charAt(9));
		int k = char2int(jmbg.charAt(10));
		int l = char2int(jmbg.charAt(11));
		int m = char2int(jmbg.charAt(12));

		// ako je osma cifra 6, nije nam bitan checksum
		if (h == 6)
			return true;

		int check = 11 - (7 * (a + g) + 6 * (b + h) + 5 * (c + i) + 4 * (d + j) + 3 * (e + k) + 2 * (f + l)) % 11;
		if (check > 9)
			check = 0;
		return m == check;

	}

	private static int char2int(char c) {
		return (int) c - 48;
	}

	public Insurance calculateInsurance(Insurance insurance) {

		Region region = regionRepository.findRegionByName(insurance.getTravel().getRegion());
		System.out.println(region);
		Sport sport = sportRepository.findSportByName(insurance.getTravel().getSport());
		System.out.println(sport);
		InsuredAmount iAmount = insuredAmountRepository
				.findInsuredAmountByAmount(insurance.getTravel().getInsuredAmount());
		System.out.println(iAmount);

		double amountToPay = 0;

		if (insurance.getTravel().getDuration() != null) {

			amountToPay += insurance.getTravel().getDuration();
		}

		if (region != null) {

			amountToPay += region.getCoefficient();
		}

		if (iAmount != null) {

			amountToPay += iAmount.getCoefficient();
		}

		if (insurance.getTravel().getLess() != 0) {

			amountToPay += insurance.getTravel().getLess() * 4;// 4 je
																// koeficijent
																// za ovu grupu
																// da ne cuvam
																// to u bazi,
																// moram da
																// pravim klasu
																// samo za to, a
																// mrzi me

		} else if (insurance.getTravel().getBetween() != 0) {

			amountToPay += insurance.getTravel().getBetween() * 3;

		} else if (insurance.getTravel().getOver() != 0) {

			amountToPay += insurance.getTravel().getOver() * 2;
		}

		if (insurance.getTravel().isDoesSport() == true && sport != null) {

			amountToPay += sport.getCoefficient();
		}

		if (insurance.getRealEstate() != null) { // ako je uzeo i realEstate

			RealestateInsPackage realestateInsPackage = realEstatePackRepository
					.findRealestateInsPackageByName(insurance.getRealEstate().getPackageRE());

			if (realestateInsPackage != null) {

				amountToPay += realestateInsPackage.getCoefficient();
			}

			if (insurance.getRealEstate().getDuration() != null) {

				amountToPay += insurance.getRealEstate().getDuration();
			}

			if (insurance.getRealEstate().getSizeRE() != null) {

				amountToPay += +insurance.getRealEstate().getSizeRE() / 10;
			}

			if (insurance.getRealEstate().getEstimatedValue() != null) {

				amountToPay += insurance.getRealEstate().getEstimatedValue() / 10000;
			}

			if (insurance.getRealEstate().getAge() != null) {
				if (insurance.getRealEstate().getAge() < 10) {
					amountToPay += insurance.getRealEstate().getAge();
				} else {
					amountToPay += insurance.getRealEstate().getAge() / 10;
				}

			}
		}

		if (insurance.getVehicle() != null) { // ako je uzeo i vehicle

			double vehicleInsurPrice = 0;

			if (insurance.getVehicle().getPackageV() != null) {
				if (insurance.getVehicle().getPackageV().equals("towing")) {

					vehicleInsurPrice = insurance.getVehicle().getPackageDetail() / 100;

				} else if (insurance.getVehicle().getPackageV().equals("repair")) {

					vehicleInsurPrice = insurance.getVehicle().getPackageDetail() / 50;

				} else if (insurance.getVehicle().getPackageV().equals("sleepover")) {

					vehicleInsurPrice = insurance.getVehicle().getPackageDetail() / 50;

				} else {

					vehicleInsurPrice = 4; // ako uzme alternativni paket
				}
			}

			if (insurance.getVehicle().getDuration() != null) {

				vehicleInsurPrice *= insurance.getVehicle().getDuration();
				amountToPay += vehicleInsurPrice;
			}

		}

		insurance.setAmountToPay(BigDecimal.valueOf(amountToPay));

		return insurance;
	}
}
