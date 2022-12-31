$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/FeatureFiles/fbFlow.feature");
formatter.feature({
  "name": "Verify the FB Login and registration feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the FB Login and Registration flows 1",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user has landed on Facebook login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginPageTest.user_has_landed_on_Facebook_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides facebook login credentials \"john\" and \"abc123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageTest.user_provides_facebook_login_credentials(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageTest.user_should_be_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify the FB Login and Registration flows 2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user has landed on Facebook login page",
  "keyword": "Given "
});
formatter.step({
  "name": "user provides facebook login credentials \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user should be able to login",
  "keyword": "Then "
});
formatter.examples({
  "name": "Test data for FB flows",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "john",
        "abc123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify the FB Login and Registration flows 2",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user has landed on Facebook login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginPageTest.user_has_landed_on_Facebook_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides facebook login credentials \"john\" and \"abc123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageTest.user_provides_facebook_login_credentials(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageTest.user_should_be_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});