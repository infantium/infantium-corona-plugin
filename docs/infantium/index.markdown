# PLUGIN_NAME.*

> --------------------- ------------------------------------------------------------------------------------------
> __Type__              [library][api.type.library]
> __Revision__          [REVISION_LABEL](REVISION_URL)
> __Keywords__          PLUGIN_NAME
> __Sample code__       
> __See also__          
> __Availability__      Basic, Pro, Enterprise
> --------------------- ------------------------------------------------------------------------------------------

## Overview

The Infantium plugin allows developers to integrate their apps with [Infantium](http://www.infantium.com), the Cognitive Platform for kids.

## Sign Up

To use the Infantium service, please [sign up](http://www.infantium.com) for an account at Infantium.

## Platforms

* Android: Yes
* iOS: No
* Mac: No
* Win: No
* Kindle: No
* NOOK: No

## Syntax

	local infantium = require "plugin.infantium"

## Functions

#### [PLUGIN_NAME.FUNCTION()][plugin.PLUGIN_NAME.FUNCTION]

#### [PLUGIN_NAME.PROPERTY][plugin.PLUGIN_NAME.PROPERTY]

## Project Settings

### SDK

When you build using the Corona Simulator, the server automatically takes care of integrating the plugin into your project. 

All you need to do is add an entry into a `plugins` table of your `build.settings`. The following is an example of a minimal `build.settings` file:

``````
settings =
{
	plugins =
	{
		-- key is the name passed to Lua's 'require()'
		["plugin.infantium"] =
		{
			-- required
			publisherId = "com.infantium",
		},
	},		
}
``````

### Enterprise

You can include the Infantium plugin by having an "android" folder inside of your project, and placing it inside its "libs" folder. From there you can already include the file "plugin.infantium.jar". You can find this file in [our example project at github](https://github.com/infantium/infantium-corona-example/tree/master/android/libs).

Once included in the "libs" folder, you can import the library by initializating it at the beginning of your Lua files with the "require" command. Here's an example:
````````
local infantium = require "plugin.infantium"
````````

## Sample Code

You can access sample code [here](https://github.com/infantium/infantium-corona-example/blob/master/Corona/main.lua).

## Support

More support is available from the Infantium team:

* [E-mail](mailto://partnerships@infantium.com)
* [Forum](http://forum.coronalabs.com/plugin/PLUGIN_NAME)
* [Developers Center](http://docs.infantium.com)
* [Plugin Publisher](http://www.infantium.com)
