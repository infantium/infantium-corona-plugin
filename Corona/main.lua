local infantium = require "plugin.infantium"

timer.performWithDelay( 500, function()
	-- Set up
	infantium.init("api", true)
	infantium.setDeveloperCredentials("androidSDK","585f946642aac847403bf6743f918892eac695f6")
	infantium.setDeveloperCredentials("username","0000000000000000000000000000000000000000")
	infantium.setDeviceInfo(500, 800)
	infantium.setContentAppUUID("00000000000000000000000000000000")
	infantium.setSubContentUUID("00000000000000000000000000000000")
end )

timer.performWithDelay( 2500, function()
	-- Start the Gameplay
	infantium.createGameplay("00000000000000000000000000000000")
	
	-- Elements examples
	infantium.addElement("element_1", 200, 150, "")
	infantium.addElement("element_2", 200, 150, "random")
	val1 = infantium.addElement("element_3", "XYZ", 150, "")
	if val1 == nil then print("nil element value") else print("not nil element value") end
	
	infantium.addNumberElement("number_element_1", -1, -1, "", 50)
	infantium.addTextElement("text_element_1", -1, -1, "", "Hola Mundo", "")
	infantium.addTextElement("text_element_2", -1, -1, "", "Hello world", "us-en")
	infantium.addShapeElement("shape_element_1", -1, -1, "", 5)
	infantium.addPaintedElement("painted_element_1", 200, 30, "")
	infantium.addPictureElement("picture_element_1", 150, 50, "")
	
	-- Goals examples
	infantium.addGoal("goal_1", -1, true, "element_1")
	infantium.addGoal("goal_2", "-1", true, "")
	val2 = infantium.addGoal("goal_3", "XYZ", true, "")
	if val2 == nil then print("nil goal value") else print("not nil goal value") end
	
	infantium.addSelectionGoal("selection_goal_1", -1, true, "", 1, -1, true, "double_tap")
	infantium.addMatchingGoal("matching_goal_1", 15000, false, "", "number_element_1", "")
	infantium.addTappingGoal("tapping_goal_1", -1, true, "", "ALL")
	
	-- Start timers
	infantium.startPlaying()
end )
	
timer.performWithDelay( 4500, function()
	-- Interactions
	infantium.newBasicInteraction("success", "", "goal_1", -1, -1, -1)
	infantium.newBasicInteraction("success", "text_element_1", "goal_2", -1, -1, -1);
	infantium.newBasicInteraction("error", "text_element_1", "goal_1", -1, -1, -1);
	infantium.newBasicInteraction("success", "", "matching_goal_1", 60000, 2, 5);
	
	-- Send the data
	infantium.sendGameRawdata()
	
	-- Close the Gameplay
	infantium.closeGameplay()
end )

local button = display.newImage( "infantium_logo.png" )
button.x = display.contentWidth / 2
button.y = 50