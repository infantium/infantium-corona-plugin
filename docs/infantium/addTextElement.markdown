# infantium.addTextElement()

> --------------------- ------------------------------------------------------------------------------------------
> __Type__              [function][api.type.function]
> __Library__           [infantium.*][plugin.infantium]
> __Return value__      [String][api.type.String]
> __Revision__          [REVISION_LABEL](REVISION_URL)
> __Keywords__          
> __Sample code__       
> __See also__          
> --------------------- ------------------------------------------------------------------------------------------


## Overview

Adds a Text element on the screen for the current scene.

## Syntax

	infantium.addTextElement( element_id, width, height, movement, text, language )


##### element_id ~^(required)^~
_[String][api.type.String]._ Unique element identifier for this scene. It will be used when referring to the element.

##### width ~^(optional)^~
_[Number][api.type.Number]._ The width of the element. -1 if not used.

##### height ~^(optional)^~
_[Number][api.type.Number]._ The height of the element. -1 if not used.

##### movement ~^(optional)^~
_[String][api.type.String]._ The type of movement of the element. "" if not used. Can take several values, it is "static" by default. More values in the official docs.

##### text ~^(required)^~
_[String][api.type.String]._ The text shown in the screen.

##### language ~^(optional)^~
_[String][api.type.String]._ Language in "en-us" format. "" if not used.


## Extra Info

More info in the [Text Elements](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/elements.html#text-elements) advanced guide of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.addTextElement("text_element_1", -1, -1, "", "Hola Mundo", "es-es")
infantium.addTextElement("text_element_2", -1, -1, "", "Hello world", "us-en")
``````
