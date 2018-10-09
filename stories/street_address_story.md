## street_address_story greet
* greet
  - utter_greet
  - utter_ask_street_address
> check_ask_street_address

## street_address_story street and house_number
> check_ask_street_address
* inform{"street":"", "house_number":""}
  - action_safe_street_address
  - utter_ask_zipcode

## street_address_story street
> check_ask_street_address
* inform{"street":""}
  - utter_ask_house_number
* inform{"house_number":""}
  - action_safe_street_address
  - utter_ask_zipcode

## street_address_story house_number
> check_ask_street_address
* inform{"house_number":""}
  - utter_ask_street
* inform{"street":""}
  - action_safe_street_address
  - utter_ask_zipcode
