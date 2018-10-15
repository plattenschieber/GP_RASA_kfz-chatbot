<!--Call Story-->

## ask phone number for call back
> ask_phone_number_call
* inform{"crf-phone-number":""} OR inform{"phone-number":""} OR inform{"crf-phone-number":"", "phone-number":""} OR inform{"crf-phone-number":"", "time": ""} OR inform{"phone-number":"", "time": ""} OR inform{"crf-phone-number":"", "phone-number":"", "time": ""}
 - action_save_user_phone_number
 - slot{"user_phone_number": ""}
 - utter_confirm_phone_number
> confirm_phone_number_call

## Wrong phone number, restart story call back
> confirm_phone_number_call
* deny
 - utter_ask_phone_number
> ask_phone_number_call

## Right phone number without email and end of story call back
> confirm_phone_number_call
* confirm
 - utter_ask_optional_email
* deny
 - utter_goodbye_call
 
## Right phone number with email
> confirm_phone_number_call
* confirm
 - utter_ask_optional_email
* confirm
 - utter_ask_email
> enter_email

<!-- END -->

<!--Report Damage Story-->

## Ask for phone number
> ask_phone_number
* inform{"crf-phone-number":""} OR inform{"phone-number":""} OR inform{"crf-phone-number":"", "phone-number":""} OR inform{"crf-phone-number":"", "time": ""} OR inform{"phone-number":"", "time": ""} OR inform{"crf-phone-number":"", "phone-number":"", "time": ""}
 - action_save_user_phone_number
 - slot{"user_phone_number": ""}
 - utter_confirm_phone_number
> confirm_phone_number

## Wrong phone number, restart story ask phone number
> confirm_phone_number
* deny
 - utter_ask_phone_number
> ask_phone_number  

## Right phone number with email
> confirm_phone_number
* confirm
  - utter_ask_optional_email
> ask_optional_email
  
## Ask for optional email and confirm
> ask_optional_email
* confirm
 - utter_ask_email
> enter_email
 
## Ask for optional email and deny
> ask_optional_email
* deny
 - utter_ask_street_address
> check_ask_street_address

<!-- END -->