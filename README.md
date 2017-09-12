application log-events alert 
---------------------------

Flume
--------
 
 - flume is streaming api with capabilities of sending the events to 
 multiple backend datastores like file, elasticsearch etc
 
 - `EventNotifier` is an api to send alerts to business people or devs
 if any kind of events are consumed from a log file, or whatever source
 even before writing to the backend data stores.
 
 - currently it sends alerts to `#slack-channel`
 
 uses
 ----
 
 ```
  client.sources.source_1.interceptors = alertBusinessPeople
  client.sources.source_1.interceptors.alertBusinessPeople.regex = .*error.*
  client.sources.source_1.interceptors.alertBusinessPeople.toChannel = "#application-interuptions"
  client.sources.source_1.interceptors.alertBusinessPeople.secretKey = "jfbjghjrwhgw"
 ```
 
 TODO
 ------
 
 ```
   client.sources.source_1.interceptors = alertBusinessPeople
   client.sources.source_1.interceptors.alertBusinessPeople.regex = .*error.*
   client.sources.source_1.interceptors.alertBusinessPeople.from = "myapp@business.com"
   client.sources.source_1.interceptors.alertBusinessPeople.toChannel = "alert@business.com"
   client.sources.source_1.interceptors.alertBusinessPeople.secretKey = "mail.host.com"
 ```

to integrate with slack, create an app(client) at https://api.slack.com/ that will provide
- api identifier
- api secret

To use Web API, https://api.slack.com/apps/A593Z4P2L/incoming-webhooks

```
curl -X POST -H 'Content-type: application/json' --data '{"alertMessage":"Kafka crashed!"}' YOUR_WEBHOOK_URL_HERE
```

Web API uses a channel.


Refs
-----

https://api.slack.com/incoming-webhooks
