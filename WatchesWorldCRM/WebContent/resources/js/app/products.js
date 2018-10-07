$(function() {
	var availableTags = [ "black", "Blue", "Brown", "Cyan", "Green", "Grey",
			"Magneta", "Orange", "Pink", "Purple", "Red", "White", "Yellow" ];
	$("#dialId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "2018", "2017", "2016", "2015", "2014", "2013",
			"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005",
			"2004", "2003", "2002", "2001", "2000" ];
	$("#yearId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "New", "Old", "Used" ];
	$("#conditionId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "Available", "Not available" ];
	$("#availabilityStatusId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "Gold", "Silver" ];
	$("#productCaseId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "Gold", "Silver", "Leather" ];
	$("#braceletId").autocomplete({
		source : availableTags
	});
});

$(function() {
	var availableTags = [ "Afghanistan (AF)", "Åland Islands (AX)",
			"Albania (AL)", "Algeria (DZ)", "American Samoa (AS)",
			"Andorra (AD)", "Angola (AO)", "Anguilla (AI)", "Antarctica (AQ)",
			"Antigua & Barbuda (AG)", "Argentina (AR)", "Armenia (AM)",
			"Aruba (AW)", "Ascension Island (AC)", "Australia (AU)",
			"Austria (AT)", "Azerbaijan (AZ)", "Bahamas (BS)", "Bahrain (BH)",
			"Bangladesh (BD)", "Barbados (BB)", "Belarus (BY)", "Belgium (BE)",
			"Belize (BZ)", "Benin (BJ)", "Bermuda (BM)", "Bhutan (BT)",
			"Bolivia (BO)", "Bosnia & Herzegovina (BA)", "Botswana (BW)",
			"Brazil (BR)", "British Indian Ocean Territory (IO)",
			"British Virgin Islands (VG)", "Brunei (BN)", "Bulgaria (BG)",
			"Burkina Faso (BF)", "Burundi (BI)", "Cambodia (KH)",
			"Cameroon (CM)", "Canada (CA)", "Canary Islands (IC)",
			"Cape Verde (CV)", "Caribbean Netherlands (BQ)",
			"Cayman Islands (KY)", "Central African Republic (CF)",
			"Ceuta & Melilla (EA)", "Chad (TD)", "Chile (CL)", "China (CN)",
			"Christmas Island (CX)", "Cocos (Keeling)", "Islands (CC)",
			"Colombia (CO)", "Comoros (KM)", "Congo - Brazzaville (CG)",
			"Congo - Kinshasa (CD)", "Cook Islands (CK)", "Costa Rica (CR)",
			"Côte d’Ivoire (CI)", "Croatia (HR)", "Cuba (CU)", "Curaçao (CW)",
			"Cyprus (CY)", "Czechia (CZ)", "Denmark (DK)", "Diego Garcia (DG)",
			"Djibouti (DJ)", "Dominica (DM)", "Dominican Republic (DO)",
			"Ecuador (EC)", "Egypt (EG)", "El Salvador (SV)",
			"Equatorial Guinea (GQ)", "Eritrea (ER)", "Estonia (EE)",
			"Ethiopia (ET)", "Eurozone (EZ)", "Falkland Islands (FK)",
			"Faroe Islands (FO)", "Fiji (FJ)", "Finland (FI)", "France (FR)",
			"French Guiana (GF)", "French Polynesia (PF)",
			"French Southern Territories (TF)", "Gabon (GA)", "Gambia (GM)",
			"Georgia (GE)", "Germany (DE)", "Ghana (GH)", "Gibraltar (GI)",
			"Greece (GR)", "Greenland (GL)", "Grenada (GD)", "Guadeloupe (GP)",
			"Guam (GU)", "Guatemala (GT)", "Guernsey (GG)", "Guinea (GN)",
			"Guinea-Bissau (GW)", "Guyana (GY)", "Haiti (HT)", "Honduras (HN)",
			"Hong Kong SAR China (HK)", "Hungary (HU)", "Iceland (IS)",
			"India (IN)", "Indonesia (ID)", "Iran (IR)", "Iraq (IQ)",
			"Ireland (IE)", "Isle of Man (IM)", "Israel (IL)", "Italy (IT)",
			"Jamaica (JM)", "Japan (JP)", "Jersey (JE)", "Jordan (JO)",
			"Kazakhstan (KZ)", "Kenya (KE)", "Kiribati (KI)", "Kosovo (XK)",
			"Kuwait (KW)", "Kyrgyzstan (KG)", "Laos (LA)", "Latvia (LV)",
			"Lebanon (LB)", "Lesotho (LS)", "Liberia (LR)", "Libya (LY)",
			"Liechtenstein (LI)", "Lithuania (LT)", "Luxembourg (LU)",
			"Macau SAR China (MO)", "Macedonia (MK)", "Madagascar (MG)",
			"Malawi (MW)", "Malaysia (MY)", "Maldives (MV)", "Mali (ML)",
			"Malta (MT)", "Marshall Islands (MH)", "Martinique (MQ)",
			"Mauritania (MR)", "Mauritius (MU)", "Mayotte (YT)", "Mexico (MX)",
			"Micronesia (FM)", "Moldova (MD)", "Monaco (MC)", "Mongolia (MN)",
			"Montenegro (ME)", "Montserrat (MS)", "Morocco (MA)",
			"Mozambique (MZ)", "Myanmar (Burma)", "Namibia (NA)", "Nauru (NR)",
			"Nepal (NP)", "Netherlands (NL)", "New Caledonia (NC)",
			"New Zealand (NZ)", "Nicaragua (NI)", "Niger (NE)", "Nigeria (NG)",
			"Niue (NU)", "Norfolk Island (NF)", "North Korea (KP)",
			"Northern Mariana Islands (MP)", "Norway (NO)", "Oman (OM)",
			"Pakistan (PK)", "Palau (PW)", "Palestinian Territories (PS)",
			"Panama (PA)", "Papua New Guinea (PG)", "Paraguay (PY)",
			"Peru (PE)", "Philippines (PH)", "Pitcairn Islands (PN)",
			"Poland (PL)", "Portugal (PT)", "Puerto Rico (PR)", "Qatar (QA)",
			"Réunion (RE)", "Romania (RO)", "Russia (RU)", "Rwanda (RW)",
			"Samoa (WS)", "San Marino (SM)", "São Tomé & Príncipe (ST)",
			"Saudi Arabia (SA)", "Senegal (SN)", "Serbia (RS)",
			"Seychelles (SC)", "Sierra Leone (SL)", "Singapore (SG)",
			"Sint Maarten (SX)", "Slovakia (SK)", "Slovenia (SI)",
			"Solomon Islands (SB)", "Somalia (SO)", "South Africa (ZA)",
			"South Georgia & South Sandwich Islands (GS)", "South Korea (KR)",
			"South Sudan (SS)", "Spain (ES)", "Sri Lanka (LK)",
			"St. Barthélemy (BL)", "St. Helena (SH)", "St. Kitts & Nevis (KN)",
			"St. Lucia (LC)", "St. Martin (MF)", "St. Pierre & Miquelon (PM)",
			"St. Vincent & Grenadines (VC)", "Sudan (SD)", "Suriname (SR)",
			"Svalbard & Jan Mayen (SJ)", "Swaziland (SZ)", "Sweden (SE)",
			"Switzerland (CH)", "Syria (SY)", "Taiwan (TW)", "Tajikistan (TJ)",
			"Tanzania (TZ)", "Thailand (TH)", "Timor-Leste (TL)", "Togo (TG)",
			"Tokelau (TK)", "Tonga (TO)", "Trinidad & Tobago (TT)",
			"Tristan da Cunha (TA)", "Tunisia (TN)", "Turkey (TR)",
			"Turkmenistan (TM)", "Turks & Caicos Islands (TC)", "Tuvalu (TV)",
			"U.S. Outlying Islands (UM)", "U.S. Virgin Islands (VI)",
			"Uganda (UG)", "Ukraine (UA)", "United Arab Emirates (AE)",
			"United Kingdom (GB)", "United Nations (UN)", "United States (US)",
			"Uruguay (UY)", "Uzbekistan (UZ)", "Vanuatu (VU)",
			"Vatican City (VA)", "Venezuela (VE)", "Vietnam (VN)",
			"Wallis & Futuna (WF)", "Western Sahara (EH)", "Yemen (YE)",
			"Zambia (ZM)", "Zimbabwe (ZW)" ];
	$("#currentLocationId").autocomplete({
		source : availableTags
	});
	
	$("#countryBoughtFromId").autocomplete({
		source : availableTags
	});
	
	$("#countrySoldInId").autocomplete({
		source : availableTags
	});
});