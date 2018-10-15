## Ask for email
> enter_email
* inform{"email":""}
 - action_save_user_email
 - slot{"user_email":""}
 - utter_confirm_email
> ask_email

## Confirm email
> ask_email 
* confirm
 - utter_ask_street_address
> check_ask_street_address
 
## Deny email
> ask_email 
* deny
 - utter_ask_email
* inform{"email":""}
 - action_save_user_email
 - slot{"user_email":""}
 - utter_confirm_email
> ask_email
