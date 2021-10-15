$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/test.feature");
formatter.feature({
  "line": 1,
  "name": "test",
  "description": "",
  "id": "test",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "upload avator",
  "description": "",
  "id": "test;upload-avator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "Login baidu",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "upload avator",
  "keyword": "And "
});
formatter.examples({
  "line": 6,
  "name": "",
  "description": "",
  "id": "test;upload-avator;",
  "rows": [
    {
      "cells": [
        ""
      ],
      "line": 7,
      "id": "test;upload-avator;;1"
    },
    {
      "cells": [
        ""
      ],
      "line": 8,
      "id": "test;upload-avator;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 8,
  "name": "upload avator",
  "description": "",
  "id": "test;upload-avator;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "Login baidu",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "upload avator",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.loginBaidu()"
});
formatter.result({
  "duration": 24504218100,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//input[@name\u003d\u0027openImgBtn\u0027]//following-sibling::input\"}\n  (Session info: chrome\u003d94.0.4606.81)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027DESKTOP-NUIEQ64\u0027, ip: \u0027192.168.32.106\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 94.0.4606.81, chrome: {chromedriverVersion: 94.0.4606.41 (333e85df3c9b6..., userDataDir: C:\\Users\\Rezz\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:49599}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: d3b792ed87fbfc5f3fbedf9ceebbc6bf\n*** Element info: {Using\u003dxpath, value\u003d//input[@name\u003d\u0027openImgBtn\u0027]//following-sibling::input}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat controller.WebOperation.clickElementByAction(WebOperation.java:34)\r\n\tat stepDefinition.StepDefinition.loginBaidu(StepDefinition.java:58)\r\n\tat ✽.Given Login baidu(src/test/resources/features/test.feature:3)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinition.Click()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 814809800,
  "status": "passed"
});
});