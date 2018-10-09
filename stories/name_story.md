## Enter What ToDo NAME
> enter_what_todo
* what_todo{"select_action": "report_damage"}
  - slot{"select_action": "report_damage"}
  - utter_be_nice
  - utter_ask_name
> enter_name

## Enter What ToDo with first and last name already set
> enter_what_todo
* what_todo{"select_action": "report_damage", "first_name":"", "last_name": ""}
  - slot{"select_action": "report_damage", "first_name":"", "last_name": ""} 
  - utter_be_nice
  - utter_name
  - utter_ask_telephone
> enter_telephone

## Enter What ToDo with first already set
* what_todo{"select_action": "report_damage", "first_name":""}
  - slot{"select_action": "report_damage", "first_name":""}
  - utter_be_nice
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number
 
## Enter What ToDo with last already set
* what_todo{"select_action": "report_damage", "last_name": ""}
  - slot{"select_action": "report_damage", "last_name": ""} 
  - utter_be_nice
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number

## Enter Name
> enter_name
* inform{"first_name":"", "last_name": ""}
  - slot{"first_name":"", "last_name": ""} 
  - utter_name
  - utter_ask_telephone
> enter_telephone

## Enter First_Name then Last_Name
> enter_name  
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number
 
## Enter Last_Name
> enter_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_name
  - utter_ask_phone_number
> ask_phone_number

