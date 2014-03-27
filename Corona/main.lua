local infantium = require "plugin.infantium"

-- This event is dispatched to the global Runtime object
-- by `didLoadMain:` in MyCoronaDelegate.mm
local function delegateListener( event )
	native.showAlert(
		"Event dispatched from `didLoadMain:`",
		"of type: " .. tostring( event.name ),
		{ "OK" } )
	--print("DelegateListener called.")
end
Runtime:addEventListener( "delegate", delegateListener )

-- This event is dispatched to the following Lua function
-- by PluginLibrary::show() in PluginLibrary.mm
local function listener( event )
	--native.showAlert( event.name, event.message, { "OK" } )
	--print("Listener called.")
end

timer.performWithDelay( 1000, function()
	infantium.init( listener )
	infantium.show( "corona" )
	--print("show timer called.")
end )

