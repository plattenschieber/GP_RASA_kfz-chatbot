<!--Report Damage Story-->

## Start Call Story
> enter_what_todo
* what_todo{"select_action": "call"}
  - slot{"select_action": "call"}
  - utter_call_meeting
  - utter_ask_name
> enter_name_call

## Enter both names for a call
> enter_name_call
* inform{"first_name":"", "last_name": ""}
  - slot{"first_name":"", "last_name": ""} 
  - utter_name
  - utter_ask_phone_number
> ask_phone_number_call

## Enter first name then last name for a call
> enter_name_call  
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number_call
 
## Enter last name then first name for a call
> enter_name_call
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number_call

<!--Report Damage Story-->

## Start Report Damage Story
> enter_what_todo
* what_todo{"select_action": "report_damage"}
  - slot{"select_action": "report_damage"}
  - utter_be_nice
  - slot{"first_name":"", "last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number

## Start Report Damage Story
> enter_what_todo
* what_todo{"select_action": "report_damage"}
  - slot{"select_action": "report_damage"}
  - utter_be_nice
  - utter_ask_time
> enter_date

## Enter both names
> enter_name
* inform{"first_name":"", "last_name": ""}
  - slot{"first_name":"", "last_name": ""} 
  - utter_name
  - utter_ask_phone_number
> ask_phone_number

## Enter first name then last name
> enter_name  
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number
 
## Enter last name then first name
> enter_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number

