## Nach Telefonnummer fragen
* greet
 - utter_greet
 - utter_ask_phone_number
* inform{"phone-number":""}
 - action_save_user_phone_number
 - slot{"user_phone_number":""}
 - utter_confirm_phone_number
> ask_phone_number  

## Falsche Telefonnummer angegeben
> ask_phone_number
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
> ask_phone_number
* confirm
 - utter_goodbye