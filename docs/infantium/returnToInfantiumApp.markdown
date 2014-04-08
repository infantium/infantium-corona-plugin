# infantium.returnToInfantiumApp()

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

This method should be called after hitting the infantium button.

## Syntax

	infantium.returnToInfantiumApp(  )


## Extra Info

For more info about the Infantium Button, please refer to the [Advanced Guide](http://infantium-sdk-docs.readthedocs.org/en/latest/advanced_guides/adding_infantium_button.html) of the official docs.


## Return Value

_[String][api.type.String]._ Either *NIL* (for Plugin errors) or a string indicating the result from the SDK.


## Examples

``````lua
local infantium = require "plugin.infantium"

infantium.returnToInfantiumApp()
``````

