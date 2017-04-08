use mydbproject
db.createCollection("member")
show collections
db.member.insert(
[
	{
	  "Member_id":"1000000",
	  "Member_fname":"Harsh",
      "Member_name":"Pandey",
      "Member_insurance_status":"",
      "Member_policy_id":"",
      "Member_profession":"engineer"
	},
	{
	  "Member_id":"1000001",
	  "Member_fname":"Ujjval",
      "Member_name":"Thakkar",
      "Member_insurance_status":"",
      "Member_policy_id":"",
      "Member_profession":"Business"
	},
	{
	  "Member_id":"1000002",
	  "Member_fname":"Gaurang",
      "Member_name":"Panchal",
      "Member_insurance_status":"",
      "Member_policy_id":"",
      "Member_profession":"Doctor"
	}
]
)

db.member.find().pretty()
db.member.find(
{"Member_fname":"Ujjval"}
)