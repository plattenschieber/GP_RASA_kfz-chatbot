## Ask for date 
> enter_date
* inform{"time":""} OR inform{"time":"", "phone-number": ""} OR inform {"time":"", "street": "","house_number": "" }
 - action_save_damage_time
 - slot{"damage_time":""}
 - utter_ask_name
> enter_name
 
## Ask for callback time
> enter_callback_time
* inform{"time":""} OR inform{"time":"", "phone-number": ""}
 - action_save_callback_time
 - slot{"callback_time":""}
 - utter_confirm_callback_time
> ask_callback_time

## Confirm callback time
> ask_callback_time
* confirm
 - action_send_email
 - utter_goodbye
 
 ## Deny callback time and restart callback story
> ask_callback_time
* deny
 - utter_ask_callback_time
* inform{"time":""}  OR inform{"time":"", "phone-number": ""}
 - action_save_callback_time
 - slot{"callback_time":""}
 - utter_confirm_callback_time
> ask_callback_time
