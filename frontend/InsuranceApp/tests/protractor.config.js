exports.config = {
  specs: ['e2e/*.js'],
  baseUrl: 'http://localhost:8081',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  jasmineNodeOpts: {
    defaultTimeoutInterval: 360000
  }
}
