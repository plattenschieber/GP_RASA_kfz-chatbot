<!--Report Damage Story-->

## Ask for zipcode and city
> check_ask_zip_city
* inform{"zip":"", "city":""}
  - action_save_zip_city
  - slot{"zip_city": ""}
  - utter_ask_callback_time
> enter_callback_time

<!-- END -->
