## Datum erfragen, Callback vereinbaren 
* greet+report_damage
 - utter_greet
 - utter_ask_time
> enter_date
 
 ## Enter What ToDo DATE
> enter_what_todo
* what_todo{"select_action": "date"}
  - slot{"select_action": "date"}
  - utter_ask_time
> enter_date

## Enter a Date 
> enter_date
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