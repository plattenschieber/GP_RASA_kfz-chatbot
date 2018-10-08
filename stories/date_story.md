## Datum erfragen, Callback vereinbaren 
* greet
 - utter_greet
 - utter_ask_time
* inform{"time":""}
 - action_save_damage_time
 - slot{"damage_time":""}
 - utter_say_time
 - utter_ask_callback_time
* inform{"time":""}
 - action_save_callback_time
 - slot{"callback_time":""}
 - utter_confirm_callback_time
> ask_callback_time

## Callback-Zeit bestätigen
> ask_callback_time
* confirm
 - utter_goodbye
 
 ## Callback-Zeit nicht bestätigen
> ask_callback_time
* deny
 - utter_ask_callback_time
* inform{"time":""}
 - action_save_callback_time
 - slot{"callback_time":""}
 - utter_confirm_callback_time
> ask_callback_time