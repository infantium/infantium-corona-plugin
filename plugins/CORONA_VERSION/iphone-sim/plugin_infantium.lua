local Library = require "CoronaLibrary"

-- Create library
local lib = Library:new{ name='infantium', publisherId='com.infantium' }

-------------------------------------------------------------------------------
-- BEGIN (Insert your implementation starting here)
-------------------------------------------------------------------------------

-- This stub file substitutes the Infantium library in the unsupported simulators.
not_implemented_function = function()
	print( 'Not implemented function for this Platform.' )
end

lib.addElement = not_implemented_function
lib.addGoal = not_implemented_function
lib.addMatchingGoal = not_implemented_function
lib.addNumberElement = not_implemented_function
lib.addPaintedElement = not_implemented_function
lib.addPictureElement = not_implemented_function
lib.addSelectionGoal = not_implemented_function
lib.addShapeElement = not_implemented_function
lib.addTappingGoal = not_implemented_function
lib.addTextElement = not_implemented_function
lib.closeGameplay = not_implemented_function
lib.createGameplay = not_implemented_function
lib.init = not_implemented_function
lib.newBasicInteraction = not_implemented_function
lib.returnToInfantiumApp = not_implemented_function
lib.sendGameRawdata = not_implemented_function
lib.setContentAppUUID = not_implemented_function
lib.setDeveloperCredentials = not_implemented_function
lib.setDeviceInfo = not_implemented_function
lib.setSubContentUUID = not_implemented_function
lib.startPlaying = not_implemented_function

-------------------------------------------------------------------------------
-- END
-------------------------------------------------------------------------------

-- Return an instance
return lib