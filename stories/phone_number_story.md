<!--Call Story-->

## Nach Telefonnummer fragen for call meeting
> ask_phone_number_call
* inform{"crf-phone-number":""} OR inform{"phone-number":""} OR inform{"crf-phone-number":"", "phone-number":""}
 - action_save_user_phone_number
 - slot{"user_phone_number": ""}
 - utter_confirm_phone_number
> confirm_phone_number_call

## Falsche Telefonnummer angegeben
> confirm_phone_number_call
* deny
 - utter_ask_phone_number
> ask_phone_number_call

## Richtige Telefonnummer angegeben
> confirm_phone_number_call
* confirm
  - utter_goodbye_call

<!--Report Damage Story-->

## Nach Telefonnummer fragen 
> ask_phone_number
* inform{"crf-phone-number":""} OR inform{"phone-number":""} OR inform{"crf-phone-number":"", "phone-number":""}
 - action_save_user_phone_number
 - slot{"user_phone_number": ""}
 - utter_confirm_phone_number
> confirm_phone_number

## Falsche Telefonnummer angegeben
> confirm_phone_number
* deny
 - utter_ask_phone_number
> ask_phone_number  

## Richtige Telefonnummer angegeben
> confirm_phone_number
* confirm
  - utter_ask_street_address
> check_ask_street_address