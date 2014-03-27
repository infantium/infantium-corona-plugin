local library = require "plugin.library"

-- This event is dispatched to the global Runtime object
-- by `didLoadMain:` in MyCoronaDelegate.mm
local function delegateListener( event )
	native.showAlert(
		"Event dispatched from `didLoadMain:`",
		"of type: " .. tostring( event.name ),
		{ "OK" } )
	print("DelegateListener called.")
end
Runtime:addEventListener( "delegate", delegateListener )

-- This event is dispatched to the following Lua function
-- by PluginLibrary::show() in PluginLibrary.mm
local function listener( event )
	native.showAlert( event.name, event.message, { "OK" } )
	print("Listener called.")
end

library.init( listener )

timer.performWithDelay( 10000, function()
	library.show( "corona" )
	print("show timer called.")
end )

