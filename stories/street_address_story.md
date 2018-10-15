<!--Report Damage Story-->

## Ask for street address
> check_ask_street_address
* inform{"street":"", "house_number":""}
  - action_safe_street_address
  - slot{"street_address": ""}
  - utter_ask_zipcode
  - utter_ask_callback_time
> enter_callback_time

<!-- END -->