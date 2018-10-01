## Begrüßung und Kontaktdaten aufnehmen, business affair true, Auto wurde beschädigt, Unfallgegner ist bei Zurich versichert, Rückruf erwünscht
* greet
  - utter_greet
  - action_ask_contact_details
  - slot{"requested_slot":"form_of_address"}
* set_form_of_address{"form_of_address":""}
  - action_ask_contact_details
  - slot{"form_of_address":"herr"}
  - slot{"requested_slot":"first_name"}
* set_first_name{"first_name":""}
  - action_ask_contact_details
  - slot{"first_name":"max"}
  - slot{"requested_slot":"surname"}
* set_surname{"surname":""} <!-- Regex nötig -->
  - action_ask_contact_details
  - slot{"surname":"mustermann"}
  - slot{"requested_slot":"street_address"} 
* set_street_address{"street_address":""}
  - action_ask_contact_details
  - slot{"street_address":"musterstrasse 11"}
  - action_save_street_number
  - slot{"requested_slot":"address_zip_code"}
  - utter_ask_address_zip_code
* set_zip_code{"address_zip_code":""} <!-- Regex nötig -->
  - action_ask_contact_details 
  - slot{"address_zip_code":"12345"}
  - slot{"requested_slot":"address_city"}
* set_city{"address_city":""} <!-- Regex nötig -->
  - action_ask_contact_details
  - slot{"address_city":"musterhausen"}
  - slot{"requested_slot":"phone-number"}
* set_phone_number{"phone-number":""} <!-- Regex nötig -->
  - action_ask_contact_details
  - slot{"phone-number":"123456"}
  - slot{"requested_slot":"email"}
* set_email{"email":""} <!-- Überprüfung nötig -->
  - action_ask_contact_details
  - slot{"email":"max@mustermann.de"}
  - slot{"requested_slot":"business_affair"}
  - action_send_email
* confirm
  - action_ask_contact_details
  - slot{"business_affair":true}
  - action_ask_branch
  - slot{"requested_slot":"branch"}
* branch_selected{"branch": "kfz"}
  - action_ask_car_is_damaged
  - slot{"branch": "kfz"}
  - slot{"requested_slot":"car_is_damaged"}
* confirm 
  - action_ask_car_is_damaged
  - slot{"car_is_damaged":true}
  - slot{"requested_slot":"counterpart_is_insured"}
  - action_ask_counterpart_insured_at_zurich
* confirm
  - slot{"counterpart_is_insured":true}
  - slot{"requested_slot":"first_name_insured_party"}
  - action_ask_liability_contact_data
 * set_first_name_insured_party{"first_name_insured_party":""}
  - slot{"first_name_insured_party":"susi"}
  - slot{"requested_slot":"surname_insured_party"}
  - action_ask_liability_contact_data
* set_surname_insured_party{"surname_insured_party":""}
  - slot{"surname_insured_party":"sonnenschein"}
  - slot{"requested_slot":"insurance_number"}
  - action_ask_liability_contact_data
  - utter_ask_insurance_number
* set_insurance_number{"insurance_number":""}
  - slot{"insurance_number":"1234567"}
  - slot{"requested_slot":"license_plate"}
  - action_ask_kfz
* set_license_plate{"license_plate":""}
  - slot{"license_plate":"XXXX1234"}
  - slot{"requested_slot":"date_of_damage"}
  - action_ask_kfz
* set_date_of_damage{"date_of_damage":""}
  - slot{"date_of_damage":"12.12.2012"}
  - slot{"requested_slot":"cause_of_damage"}
  - action_ask_kfz
* set_cause_of_damage{"cause_of_damage":""}
  - slot{"cause_of_damage":"auffahrunfall"}
  - slot{"requested_slot":"damage_location"}
  - action_ask_kfz
* set_damage_location{"damage_location":""}
  - slot{"damage_location":"autobahn"}
  - slot{"requested_slot":"description_of_accident"}
  - action_ask_kfz
* set_description_of_accident{"description_of_accident":""}
  - slot{"description_of_accident":"auto ist in anderes auto und peng"}
  - slot{"requested_slot":"current_location_of_car"}
  - action_ask_kfz
* set_current_location_of_car{"current_location_of_car":""}
  - slot{"current_location_of_car":"musterstrasse"}
  - slot{"requested_slot":"is_callback_wanted"}
  - action_ask_is_callback_wanted
* confirm
  - slot{"is_callback_wanted":true}
  - slot{"requested_slot":"callback_phone_number"}
  - action_ask_callback_information
* set_callback_phone_number{"callback_phone_number":""}
  - slot{"callback_phone_number":"2345678"}
  - slot{"requested_slot":"reachability_date"}
  - action_ask_callback_information
* set_date_and_time_reachability{"reachability_date":""}
  - slot{"reachability_date":"18.09.2018 18:00"}
  - utter_goodbye
  - action_send_email
