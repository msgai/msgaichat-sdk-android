# MsgaiChat SDK Android Release Notes

## 1.1.3
2019-02-28
* Fixes for scenrios where app has Firebase setup itself.

## 1.1.2
2019-02-27
* Specifying Google Maps key is now optional. Specifying this key in manifest file will make 'Send Location' button visible otherwise this button will be hidden.
* Now app don't need to pass 'config.json' while calling MsgaiChat.init(), Instead of this app need to put attached 4 files in assets folder. copy_templates.json, faq_info.json, persistent_menu.json, theme.json
* For menu localisation, use below method.
  settings.setLanguageCode("EN"); OR settings.setLanguageCode("FR"); Current version supports two languages EN and FR.
  

## 1.1.1
2019-02-22
* SDK compatibility with apps having no action bar.
* Now app can listen to more call backs.
   * onChatActivityPaused()
   * onChatActivityStopped()
   * onChatActivityDestroyed()
* Minor performance improvements.

## 1.1.0
2019-02-06

* Performance enhancements.


