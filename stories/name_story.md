## Enter What ToDo NAME
> enter_what_todo
* what_todo{"select_action": "name"}
  - slot{"select_action": "name"}
  - utter_ask_name
> enter_name

## Enter What ToDo NAME
> enter_what_todo
* what_todo{"select_action": "name", "first_name":"", "last_name": ""}
  - slot{"first_name":"", "last_name": ""} 
  - utter_name
  - utter_ask_telephone
> enter_telephone

## Enter First_Name then Last_Name
* what_todo{"select_action": "name", "first_name":""}
  - slot{"first_name":""}
  - utter_first_name
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_last_name
  - utter_ask_phone_number
> ask_phone_number
 
## Enter Last_Name
* what_todo{"select_action": "name", "last_name": ""}
  - slot{"last_name": ""} 
  - utter_last_name
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_first_name
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
  - utter_first_name
  - utter_ask_last_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_last_name
  - utter_ask_phone_number
> ask_phone_number
 
## Enter Last_Name
> enter_name
* inform{"last_name": ""}
  - slot{"last_name": ""}
  - utter_last_name
  - utter_ask_first_name
* inform{"first_name": ""}
  - slot{"first_name":""}
  - utter_first_name
  - utter_ask_phone_number
> ask_phone_number

