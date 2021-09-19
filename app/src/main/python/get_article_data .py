import requests

## returns a list of dictionaries, where each dictionary is an article.
## Shown at the end of the file is an example dictionary entry

def getEntries(topic):

    url = "https://free-news.p.rapidapi.com/v1/search"

    querystring = {"q":topic,"lang":"en","page":"1","page_size":"25"}

    headers = {
        'x-rapidapi-key': "ae13d5a1f8mshfc10c5dff418fcfp10c6dfjsn27e1afad274f",
        'x-rapidapi-host': "free-news.p.rapidapi.com"
        }

    response = requests.request("GET", url, headers=headers, params=querystring)

    data = response.json()["articles"]
    return data

## tests:
#topic = "coronavirus"
#print(getEntries(topic))

########## TONE ANALYZER

import json
from ibm_watson import ToneAnalyzerV3
from ibm_cloud_sdk_core.authenticators import IAMAuthenticator

def get_tone(text):

    authenticator = IAMAuthenticator('aUhGEzT6N1WL7he4lQEpkEhrkq6uIjOd9IC8X1NBe5za')
    tone_analyzer = ToneAnalyzerV3(
        version='2017-09-21',
        authenticator=authenticator
    )

    tone_analyzer.set_service_url('https://api.au-syd.tone-analyzer.watson.cloud.ibm.com')

    tone_analysis = tone_analyzer.tone(
        {'text': text},
        content_type='application/json'
    ).get_result()

    tones = tone_analysis["document_tone"]["tones"]

    sum_tones = []
    for i in range(len(tones)):
        sum_tones.append([tones[i]["tone_name"],tones[i]["score"]])
    return sum_tones

######### MAIN

def get_topic_data(topic):
    entries = getEntries(topic)
    #print(entries)

    new_entries = []
    for i in range(len(entries)):
        summary = entries[i]["summary"]

        title = entries[i]["title"]
        date = entries[i]["published_date"]
        link = entries[i]["link"]
        clean_url = entries[i]["clean_url"]
        topic = entries[i]["topic"]
        
        if not summary or not title or not date or not link or not clean_url or not topic:
            continue
        
        tones = get_tone(summary)
        
        if not tones:
            continue

        entry_dict = {"title":title, "date":date, "link":link, "clean_url":clean_url, "topic":topic, "tone":tones}
        new_entries.append(entry_dict)

    #to string
    toStr = ""

    for i in range(len(new_entries)):
        tones = new_entries[i]["tone"]
        tonesStr = str(tones[0][0])+","+str(tones[0][1])
        if len(tones) > 1:
            tonesStr += "!" + str(tones[1][0])+","+str(tones[1][1])
        toStr += "{" + new_entries[i]["title"] + ";" + new_entries[i]["date"] + ";" + new_entries[i]["link"] + ";" + new_entries[i]["clean_url"] + ";" + new_entries[i]["topic"] + ";" + tonesStr
    return toStr
        

topic_data = get_topic_data("coronavirus")
print(topic_data)


##### example dictionary entry:
##{'title': 'Is another coronavirus lockdown coming?',
## 'date': '2021-09-13 16:00:00',
## 'link': 'https://www.thetimes.co.uk/article/is-another-coronavirus-lockdown-coming-n5qsxx2w5',
## 'clean_url': 'thetimes.co.uk',
## 'topic': 'economics',
## 'tone': [['Tentative', 0.601046], ['Analytical', 0.797462]]}
