<!--Report Damage Story-->

## Ask for street address
> check_ask_street_address
* inform{"street":"", "house_number":""}
  - action_save_street_address
  - slot{"street_address": ""}
  - utter_ask_zipcode
> check_ask_zip_city
