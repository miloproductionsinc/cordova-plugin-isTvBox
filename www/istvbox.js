// Empty constructor
function IsTvBox() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
IsTvBox.prototype.checkTvBox = function(successCallback, errorCallback) {
  var options = {};
  cordova.exec(successCallback, errorCallback, 'IsTvBox', 'checkTvBox', [options]);
}

// Installation constructor that binds ToastyPlugin to window
IsTvBox.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.isTvBox = new IsTvBox();
  return window.plugins.isTvBox;
};
cordova.addConstructor(IsTvBox.install);