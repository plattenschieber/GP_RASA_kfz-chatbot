## Nach Telefonnummer fragen
> enter_what_todo
* what_todo{"select_action": "phone"}
 - slot{"select_action": "phone"}
 - utter_ask_phone_number
> ask_phone_number 
 
> ask_phone_number
* inform{"phone-number":""}
 - action_save_user_phone_number
 - slot{"user_phone_number":""}
 - utter_confirm_phone_number
> confirm_phone_number

## Falsche Telefonnummer angegeben
> confirm_phone_number
* deny
 - action_save_user_phone_number
 - slot{"user_phone_number":""}
 - utter_ask_phone_number
* inform{"phone-number":""}
 - action_save_user_phone_number
 - slot{"user_phone_number":""}
 - utter_confirm_phone_number
> ask_phone_number  

## Richtige Telefonnummer angegeben
> confirm_phone_number
* confirm
 - utter_goodbye