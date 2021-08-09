$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/confirmNews.feature");
formatter.feature({
  "line": 2,
  "name": "Confirm the news is valid by Searching in Google",
  "description": "",
  "id": "confirm-the-news-is-valid-by-searching-in-google",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@NewsValidation"
    },
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 1,
      "name": "@newsregression"
    }
  ]
});
formatter.scenarioOutline({
  "line": 18,
  "name": "To Confirm the news is valid",
  "description": "",
  "id": "confirm-the-news-is-valid-by-searching-in-google;to-confirm-the-news-is-valid",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 17,
      "name": "@Checknews"
    },
    {
      "line": 17,
      "name": "@searchConfirmNews"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "Launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "navigate to \"News\" home page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I confirm the news \"\u003csplitword\u003e\" by searching in google",
  "rows": [
    {
      "cells": [
        "\u003cnewsToSearch\u003e"
      ],
      "line": 22
    }
  ],
  "keyword": "And "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "confirm-the-news-is-valid-by-searching-in-google;to-confirm-the-news-is-valid;",
  "rows": [
    {
      "cells": [
        "newsToSearch",
        "splitword"
      ],
      "line": 24,
      "id": "confirm-the-news-is-valid-by-searching-in-google;to-confirm-the-news-is-valid;;1"
    },
    {
      "cells": [
        "Swimming Australia boss Alex Baumann quits after three months in the job",
        "the"
      ],
      "line": 25,
      "id": "confirm-the-news-is-valid-by-searching-in-google;to-confirm-the-news-is-valid;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 92600,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "To Confirm the news is valid",
  "description": "",
  "id": "confirm-the-news-is-valid-by-searching-in-google;to-confirm-the-news-is-valid;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 1,
      "name": "@NewsValidation"
    },
    {
      "line": 1,
      "name": "@newsregression"
    },
    {
      "line": 17,
      "name": "@searchConfirmNews"
    },
    {
      "line": 17,
      "name": "@Checknews"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "Launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "navigate to \"News\" home page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I confirm the news \"the\" by searching in google",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Swimming Australia boss Alex Baumann quits after three months in the job"
      ],
      "line": 22
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Home_stepdefn.launch_The_Application()"
});
formatter.result({
  "duration": 12779982800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "News",
      "offset": 13
    }
  ],
  "location": "Home_stepdefn.navigate_To_Home_Page(String)"
});
formatter.result({
  "duration": 3271944700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "the",
      "offset": 20
    }
  ],
  "location": "Home_stepdefn.i_Confirm_The_News_By_Searching_In_Google(String,DataTable)"
});
formatter.result({
  "duration": 9950900500,
  "status": "passed"
});
formatter.after({
  "duration": 84503200,
  "status": "passed"
});
});