import { Injectable } from '@angular/core';

@Injectable()
export class GlobalsService {

  constructor() { }

  public article = {
    elements : {
      "naucniRad" : {
        menu: [{
          caption: "Add <title>",
          action: Xonomy.newElementChild,
          actionParameter: "<title>\"\"</title>"
        },
        {
          caption: "Add <author>",
          action: Xonomy.newElementChild,
          actionParameter: "<author></author>"
        },
        {
          caption: "Add <abstract>",
          action: Xonomy.newElementChild,
          actionParameter: "<abstract></abstract>"
        },
        {
          caption: "Add <keyword>",
          action: Xonomy.newElementChild,
          actionParameter: "<keyword>\"\"</keyword>"
        },
        {
          caption: "Add <paperType>",
          action: Xonomy.newElementChild,
          actionParameter: "<paperType>\"\"</paperType>"
        },
        {
          caption: "Add <content>",
          action: Xonomy.newElementChild,
          actionParameter: "<content></content>"
        },
        {
          caption: "Add <reference>",
          action: Xonomy.newElementChild,
          actionParameter: "<reference></reference>"
        }]
      },
      "title" : {
        akset: Xonomy.askString,
        menu: [{
          caption: "Delete <title>",
          action: Xonomy.deleteElement
        }]
      },
      "author" : {
        menu: [{
          caption: "Delete <author>",
          action: Xonomy.deleteElement
        },
        {
          caption: "Add <userName>",
          action: Xonomy.newElementChild,
          actionParameter: "<userName>\"\"</userName>",
        },
        {
          caption: "Add <name>",
          action: Xonomy.newElementChild,
          actionParameter: "<name>\"\"</name>",
        },
        {
          caption: "Add <lastName>",
          action: Xonomy.newElementChild,
          actionParameter: "<lastName>\"\"</lastName>"
        },
        {
          caption: "Add <university>",
          action: Xonomy.newElementChild,
          actionParameter: "<university>\"\"</university>"
        },
        {
          caption: "Add <city>",
          action: Xonomy.newElementChild,
          actionParameter: "<city>\"\"</city>"
        },
        {
          caption: "Add <state>",
          action: Xonomy.newElementChild,
          actionParameter: "<state>\"\"</state>"
        },
        {
          caption: "Add <zipCode>",
          action: Xonomy.newElementChild,
          actionParameter: "<zipCode>\"\"</zipCode>"
        },
        {
          caption: "Add <address>",
          action: Xonomy.newElementChild,
          actionParameter: "<address>\"\"</address>"
        }]
      },
      "userName" : {
        akset: Xonomy.askString,
      },
      "name" : {
         asker: Xonomy.askString
      },
      "lastName" : {
        asker: Xonomy.askString
      },
      "city" : {
        akset: Xonomy.askString
      },
      "university" : {
        asker: Xonomy.askString
      },
      "state" : {
         asker: Xonomy.askString
      },
      "address" : {
        asker: Xonomy.askString,
        menu: [{
          caption: "Delete <address>",
          action: Xonomy.deleteElement
        }]

      },
      "zipCode" : {
        asker: Xonomy.askString,
        menu: [{
          caption: "Delete <zipCode>",
          action: Xonomy.deleteElement
        }]
      },
      "abstract" : {
        menu: [{
          caption: "Delete <abstract>",
          action: Xonomy.deleteElement
        },
        {
          caption: "Add <deaultAbstract>",
          action: Xonomy.newElementChild,
          actionParameter: "<deaultAbstract></deaultAbstract>",
        },
        {
          caption: "Add <freeAbstract>",
          action: Xonomy.newElementChild,
          actionParameter: "<freeAbstract>\"\"</freeAbstract>"
        }]
      },
      "deaultAbstract" : {
        menu : [{
          caption: "Delete <deaultAbstract>",
          action: Xonomy.deleteElement
        },
        {
          caption: "Add <purpose>",
          action: Xonomy.newElementChild,
          actionParameter: "<purpose>\"\"</purpose>"
        },
        {
          caption: "Add <designMethodologyApproach>",
          action: Xonomy.newElementChild,
          actionParameter: "<designMethodologyApproach>\"\"</designMethodologyApproach>"
        },
        {
          caption: "Add <findings>",
          action: Xonomy.newElementChild,
          actionParameter: "<findings>\"\"</findings>"
        },
        {
          caption: "Add <researchLimitationsImplications>",
          action: Xonomy.newElementChild,
          actionParameter: "<researchLimitationsImplications>\"\"</researchLimitationsImplications>"
        },
        {
          caption: "Add <practicalImplications>",
          action: Xonomy.newElementChild,
          actionParameter: "<practicalImplications>\"\"</practicalImplications>"
        },
        {
          caption: "Add <originalityValue>",
          action: Xonomy.newElementChild,
          actionParameter: "<originalityValue>\"\"</originalityValue>"
        }]
      },
      "purpose" : {
        asker: Xonomy.askString
      },
      "designMethodologyApproach" : {
        asker: Xonomy.askString
      },
      "findings" : {
        asker: Xonomy.askString
      },
      "researchLimitationsImplications" : {
        asker: Xonomy.askString
      },
      "practicalImplications" : {
        asker: Xonomy.askString
      },
      "originalityValue" : {
        asker: Xonomy.askString
      },
      "freeAbstract" : {
        asker: Xonomy.askString,
        menu : [{
          caption: "Delete <freeAbstract>",
          action: Xonomy.deleteElement
        }]
      },
      "keyword" : {
        asker: Xonomy.askString,
        menu : [{
          caption: "Delete <keyword>",
          action: Xonomy.deleteElement
        }]
      },
      "paperType" : {
        asker: Xonomy.askString,
        menu : [{
          caption: "Delete <paperType>",
          action: Xonomy.deleteElement
        }]
      },
      "content" : {
        menu: [{
          caption: "Delete <content>",
          action: Xonomy.deleteElement
        },
        {
          caption: "Add <chapter>",
          action: Xonomy.newElementChild,
          actionParameter: "<chapter></chapter>",
        }]
      },
      "chapter" : {
        menu: [{
          caption: "Delete <chapter>",
          action: Xonomy.deleteElement
        },
        {
          caption: "Add <title>",
          action: Xonomy.newElementChild,
          actionParameter: "<title>\"\"</title>",
        },
        {
          caption: "Add <chapter>",
          action: Xonomy.newElementChild,
          actionParameter: "<chapter></chapter>",
        },
        {
          caption: "Add <paragraph>",
          action: Xonomy.newElementChild,
          actionParameter: "<paragraph>\"\"</paragraph>"
        }]
      },
      "paragraph" : {
        asker: Xonomy.askString
      }
    }
  };
}
