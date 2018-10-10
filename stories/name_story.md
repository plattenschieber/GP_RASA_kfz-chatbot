<!--Call Story-->

## Enter What ToDo Call
> enter_what_todo
* what_todo{"select_action": "call"}
  - slot{"select_action": "call"}
  - utter_call_meeting
  - utter_ask_name
> enter_name_call

## Enter Name Call
> enter_name_call
* inform{"first_name":"", "last_name": ""}
  - slot{"first_name":"", "last_name": ""} 
  - utter_name
  - utter_ask_phone_number
> ask_phone_number_call

## Enter First_Name then Last_Name
> enter_name_call  
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number_call
 
## Enter Last_Name
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

## Enter What ToDo Report Damage
> enter_what_todo
* what_todo{"select_action": "report_damage"}
  - slot{"select_action": "report_damage"}
  - utter_be_nice
  - slot{"first_name":"", "last_name": ""}
  - utter_name
> ask_phone_number_call

## Enter What ToDo Report Damage
> enter_what_todo
* what_todo{"select_action": "report_damage"}
  - slot{"select_action": "report_damage"}
  - utter_be_nice
  - utter_ask_name
> enter_name_call


