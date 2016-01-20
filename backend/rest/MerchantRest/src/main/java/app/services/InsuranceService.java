package app.services;

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

import app.model.Insurance;
import app.repository.local.InsuranceRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;
import app.validators.InsuranceValidation;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepository;
	public static final int JMBG_OK = 0;
	public static final int JMBG_INVALID = 1;
	public static final int JMBG_WARNING = 2;
	
	private static Pattern jmbgPattern = Pattern.compile("\\d{13}");
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");


	private static final Logger logger = Logger.getLogger(InsuranceService.class);

	public Map<String, Object> create(Insurance insurance) {

		Map<String, Object> response;

		if (!InsuranceValidation.validateInsurance(insurance)) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance created successfully");
		response.put("insurance", insurance);

		logger.info("Insurance created successfully");

		return response;
	}

	public List<Insurance> findAll() {

		logger.info("List all insurances");
		return insuranceRepository.findAll();
	}

	public Insurance findById(String insId) {

		Insurance insurance = insuranceRepository.findOne(insId);
		logger.info("Find insurance with id: " + insId);

		if (insurance == null) {
			throw new NotFoundException();
		}

		return insurance;
	}

	public String remove(String insId) {

		logger.info("Removing insurance with id: " + insId);
		insuranceRepository.delete(insId);
		return "removed";
	}

	public Map<String, Object> edit(Insurance insurance) {

		Map<String, Object> response;

		if (!InsuranceValidation.validateInsurance(insurance)) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance updated successfully");
		response.put("insurance", insurance);

		logger.info("Insurance updated successfully");

		return response;
	}
	
	//validacija jmbg
	
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
			return JMBG_INVALID;
		Matcher matcher = jmbgPattern.matcher(jmbg);
		if (!matcher.matches())
			return JMBG_INVALID;
		if (extractDateFromJmbg(jmbg) == null)
			return JMBG_INVALID;

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
			return m == check ? JMBG_OK : JMBG_INVALID;
		else
			return m == check ? JMBG_OK : JMBG_WARNING;
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
}
