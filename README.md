# isTVBox
This plugin will detect if app is running or android Tv device or non tv.
# Adding 
cordova plugin add https://github.com/miloproductionsinc/cordova-plugin-isTvBox.git

# USAGE
 window.plugins.isTvBox.checkTvBox(function(success) {
            if(success=="TV Device"){
                // for tv
            }else{
               //for non tv
            }
          }, function(err) {
            console.log('Uh oh... ' + err);
          });