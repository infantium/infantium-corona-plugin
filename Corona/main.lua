-----------------------------------
---- Load the Infantium Plugin ----
-----------------------------------
local infantium = require "plugin.infantium"

timer.performWithDelay( 500, function()
	------------------
	----- Set up ----- 
	------------------
	
	-- Method 'init': initialize the Plugin
	-- Params
	---- String server: either "api" or "beta", that is for production or development environments
	---- Boolean debug: configures the logs printed in the Android Log
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- Extra info
	---- Can be called without arguments, which default to "beta" and true.
	infantium.init("beta", true)
	
	-- Method 'setDeveloperCredentials': identify the developer against the server
	-- Params
	---- String api_username: private developer api_username, provided by Infantium
	---- String api_key: private developer api_key, provided by Infantium
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.setDeveloperCredentials("username","0000000000000000000000000000000000000000")
	
	-- Method 'setDeviceInfo': set the size in pixels of the device
	-- Params
	---- Integer width: width in pixels of the device.
	---- Integer height: height in pixels of the device.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.setDeviceInfo(500, 800)
	
	-- Method 'setContentAppUUID': identify the App against the server
	-- Params
	---- String contentapp_uuid: private UUID of the App, provided by Infantium.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.setContentAppUUID("00000000000000000000000000000000")
	
	-- Method 'setSubContentUUID': identify which subcontent the kid is playing
	-- Params
	---- String subcontent_uuid: private UUID of the subcontent being played, provided by Infantium.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- Extra info
	---- Not all the apps will need to use this function.
	infantium.setSubContentUUID("00000000000000000000000000000000")
end )

timer.performWithDelay( 2500, function()
	------------------------------
	----- Start the Gameplay -----
	------------------------------
	
	-- Method 'createGameplay': represents the start of a game session by a kid. During this session
	---- many data will be sent, the gameplay will only be closed when the kid stops playing. More info
	---- in the official docs: http://docs.infantium.com .
	-- Params
	---- String subcontent_uuid: private UUID of the subcontent being played, provided by Infantium.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.createGameplay("00000000000000000000000000000000")
	
	-----------------------------
	----- Elements examples -----
	-----------------------------
	
	-- Method 'addElement': adds one element on the screen for the current scene.
	-- Params
	---- String element_id: unique element identifier for this scene. It will be used when referring to the element.
	---- Integer width (optional): the width of the element. -1 if not used.
	---- Integer height (optional): the height of the element. -1 if not used.
	---- String movement (optional): the type of movement of the element. "" if not used.
	------ It can take several values, it is "static" by default. More values in the official docs.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.addElement("element_1", 200, 150, "")
	infantium.addElement("element_2", 200, 150, "random")
	
	-- This is an example of an incorrect call, thus it will return NIL:
	val1 = infantium.addElement("element_3", "XYZ", 150, "")
	if val1 == nil then print("nil element value") else print("not nil element value") end
	
	-- Method 'addNumberElement': adds a Number element on the screen for the current scene.
	-- Params
	---- String element_id: unique element identifier for this scene. It will be used when referring to the element.
	---- Integer width (optional): the width of the element. -1 if not used.
	---- Integer height (optional): the height of the element. -1 if not used.
	---- String movement (optional): the type of movement of the element. "" if not used.
	------ It can take several values, it is "static" by default. More values in the official docs.
	---- Integer value: the value of the element.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among elements explained in the Advanced Guides section of the official docs.
	infantium.addNumberElement("number_element_1", -1, -1, "", 50)
	
	-- Method 'addTextElement': adds a Text element on the screen for the current scene.
	-- Params
	---- String element_id: unique element identifier for this scene. It will be used when referring to the element.
	---- Integer width (optional): the width of the element. -1 if not used.
	---- Integer height (optional): the height of the element. -1 if not used.
	---- String movement (optional): the type of movement of the element. "" if not used.
	------ It can take several values, it is "static" by default. More values in the official docs.
	---- String text: the text shown in the screen.
	---- String language (optional): language in "en-us" format. "" if not used.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among elements explained in the Advanced Guides section of the official docs.
	infantium.addTextElement("text_element_1", -1, -1, "", "Hola Mundo", "es-es")
	infantium.addTextElement("text_element_2", -1, -1, "", "Hello world", "us-en")
	
	-- Method 'addTextElement': adds a Shape element on the screen for the current scene.
	-- Params
	---- String element_id: unique element identifier for this scene. It will be used when referring to the element.
	---- Integer width (optional): the width of the element. -1 if not used.
	---- Integer height (optional): the height of the element. -1 if not used.
	---- String movement (optional): the type of movement of the element. "" if not used.
	------ It can take several values, it is "static" by default. More values in the official docs.
	---- Integer n_sides (optional): number of sides of the shape
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among elements explained in the Advanced Guides section of the official docs.
	infantium.addShapeElement("shape_element_1", -1, -1, "", 5)
	
	-- Method 'addPaintedElement': adds one Painted element on the screen for the current scene.
	-- Method 'addPictureElement': adds one Picture element on the screen for the current scene.
	-- Params
	---- String element_id: unique element identifier for this scene. It will be used when referring to the element.
	---- Integer width (optional): the width of the element. -1 if not used.
	---- Integer height (optional): the height of the element. -1 if not used.
	---- String movement (optional): the type of movement of the element. "" if not used.
	------ It can take several values, it is "static" by default. More values in the official docs.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among elements explained in the Advanced Guides section of the official docs.
	infantium.addPaintedElement("painted_element_1", 200, 30, "")
	infantium.addPictureElement("picture_element_1", 150, 50, "")
	
	--------------------------
	----- Goals examples -----
	--------------------------
	
	-- Method 'addGoal': adds one goal for the current scene.
	-- Params
	---- String goal_id: unique goal identifier for this scene. It will be used when referring to the goal later on.
	---- Integer time_limit (optional): the limit of time in milliseconds the kid can interact with this goal. -1 if not used.
	---- Boolean auto_eval (optional): indicates that a child action automatically triggers evaluation. true if not used.
	---- String instructions (optional): if there are instructions for the current scene, they can be defined as an element.
	------ Here there is the link to that element, it's id. "" if not used.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.addGoal("goal_1", -1, true, "text_element_2")
	infantium.addGoal("goal_2", "-1", true, "")
	
	-- This is an example of an incorrect call, thus it will return NIL:
	val2 = infantium.addGoal("goal_3", "XYZ", true, "")
	if val2 == nil then print("nil goal value") else print("not nil goal value") end
	
	-- Method 'addSelectionGoal': adds one Selection goal for the current scene.
	-- Params
	---- String goal_id: unique goal identifier for this scene. It will be used when referring to the goal later on.
	---- Integer time_limit (optional): the limit of time in milliseconds the kid can interact with this goal. -1 if not used.
	---- Boolean auto_eval (optional): indicates that a child action automatically triggers evaluation. true if not used.
	---- String instructions (optional): if there are instructions for the current scene, they can be defined as an element.
	------ Here there is the link to that element, it's id. "" if not used.
	---- Integer n_correct_choices (optional): number of correct choices from which to choose. -1 if not used.
	---- Integer n_incorrect_choices (optional): number of incorrect choices available to choose. -1 if not used.
	---- Boolean unique_solution (optional): false if the kid can choose different correct solutions. true if not used.
	---- String needed_action (optional): which action triggers the selection. Choices can be "tap", "double_tap", "drag", among
	------ others. "" if not used.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among goals explained in the Advanced Guides section of the official docs.
	infantium.addSelectionGoal("selection_goal_1", -1, true, "", 1, -1, true, "double_tap")
	
	-- Method 'addMatchingGoal': adds one Matching goal for the current scene.
	-- Params
	---- String goal_id: unique goal identifier for this scene. It will be used when referring to the goal later on.
	---- Integer time_limit (optional): the limit of time in milliseconds the kid can interact with this goal. -1 if not used.
	---- Boolean auto_eval (optional): indicates that a child action automatically triggers evaluation. true if not used.
	---- String instructions (optional): if there are instructions for the current scene, they can be defined as an element.
	------ Here there is the link to that element, it's id. "" if not used.
	---- String matching_element: element which the kid should interact with. The element to be matched.
	---- String correspondence_type (optional): type of correspondence between the element to be matched and the target. This can
	------ can be "shape", "size", "color", among others. More info in the official docs. "" if not used.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among goals explained in the Advanced Guides section of the official docs.
	infantium.addMatchingGoal("matching_goal_1", 15000, false, "", "number_element_1", "")
	
	-- Method 'addTappingGoal': adds one Matching goal for the current scene.
	-- Params
	---- String goal_id: unique goal identifier for this scene. It will be used when referring to the goal later on.
	---- Integer time_limit (optional): the limit of time in milliseconds the kid can interact with this goal. -1 if not used.
	---- Boolean auto_eval (optional): indicates that a child action automatically triggers evaluation. true if not used.
	---- String instructions (optional): if there are instructions for the current scene, they can be defined as an element.
	------ Here there is the link to that element, it's id. "" if not used.
	---- String element_to_tap: element which the kid should interact with. It can be the keyword "ALL" which references all the
	------ elements on the screen.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- Differences among goals explained in the Advanced Guides section of the official docs.
	infantium.addTappingGoal("tapping_goal_1", -1, true, "", "ALL")
	
	------------------------
	----- Start timers -----
	------------------------
	
	-- Method 'startPlaying': triggers the timers on the current scene. To be called when the kid can actually start interacting
	---- with the screen (after animations, or preloads, etc).
	-- Params: None
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- In the walkthroughs of the official docs you can find further info about this function.
	infantium.startPlaying()
end )
	
timer.performWithDelay( 4500, function()
	------------------------
	----- Interactions -----
	------------------------
	
	-- Method 'newBasicInteraction': registers an interaction of the kid with the app.
	-- Params
	---- String interaction_t: the type of the interaction: "success", "error", "none".
	---- String object_type (optional): relates this interaction to an element. This parameter should be it's id. "" if not used.
	---- String goal_type: relates this interaction to a goal. This parameter should be it's id.
	---- Integer lifetime (optional): amount of time in milliseconds the kid had available to make this interaction. -1 if not used.
	---- Integer n_concurrent_oks (optional): number of other available correct answers during the interaction.
	---- Integer n_concurrent_kos (optional): number of other available incorrect answers during the interaction.
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	infantium.newBasicInteraction("success", "", "goal_1", -1, -1, -1)
	infantium.newBasicInteraction("success", "text_element_1", "goal_2", -1, -1, -1);
	infantium.newBasicInteraction("error", "text_element_1", "goal_1", -1, -1, -1);
	infantium.newBasicInteraction("success", "", "matching_goal_1", 60000, 2, 5);
	
	-------------------------
	----- Send the data -----
	-------------------------
	
	-- Method 'sendGameRawdata': send the data to the server.
	-- Params: none
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- This method restarts the data in the scene, so it should be called at the end of that scene. After this, elements and goals
	------ should be introduced again.
	infantium.sendGameRawdata()
	
	------------------------------
	----- Close the Gameplay -----
	------------------------------
	
	-- Method 'closeGameplay': close the current gameplay.
	-- Params: none
	-- Returns
	---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
	-- More info
	---- This method should be called when the kid stops the game session, that is, goes to the main menu.
	infantium.closeGameplay()
end )

------------------------------
----- Additional methods -----
------------------------------

-- Method 'returnToInfantiumApp': this method should be called after hitting the infantium button
-- Params: none
-- Returns
---- String response: either NIL (for Plugin errors) or a string indicating the result from the SDK.
-- More info
---- For more info about the Infantium Button, please refer to the Advanced Guides of the official docs.

--infantium.returnToInfantiumApp()


----------------------------------------------------
----- Example app to show a logo on the screen -----
----------------------------------------------------
local button = display.newImage( "infantium_logo.png" )
button.x = display.contentWidth / 2
button.y = 50