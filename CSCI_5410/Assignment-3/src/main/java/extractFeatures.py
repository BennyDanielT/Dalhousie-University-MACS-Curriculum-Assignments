import urllib.parse
import re
import json
import boto3

def lambda_handler(event, context):

    s3cli = boto3.client("s3")
    s3Upload = boto3.resource('s3')
    Upload_bucket = "tagsb00899629"
    dictionary = {}
    bucket_name = event['Records'][0]['s3']['bucket']['name']
    key = urllib.parse.unquote_plus(event['Records'][0]['s3']['object']['key'], encoding='utf-8')
    json_file_name = key.split('.')
    file_content = s3cli.get_object(Bucket=bucket_name, Key=key)['Body'].read().decode("utf-8")
    file_content_main = file_content.replace('\n',' ');
    all_words = file_content_main.split(" ")
    entities = re.sub(r"\bThe\b", '',str(all_words))
    entities = re.sub(r"\bThis\b", '',entities)
    entities = re.sub(r"\bThen\b", '',entities)
    entities = re.sub(r"\bIt\b", '',entities)
    entities = re.sub(r"\bAt\b", '',entities)
    entities = re.sub(r"\bAnd\b", '',entities)
    entities = re.sub(r"\bIn\b", '',entities)
    entities = re.sub(r"\bHowever\b", '',entities)
    entities = re.sub(r"\bIf\b", '',entities)
    entities = re.findall(r'(?<!\.\s)(?!^)\b([A-Z]\w*(?:\s+[A-Z]\w*)*)',entities)
    print(entities)
    for words in entities:
        if words in dictionary:
            dictionary[str(words)] = dictionary[str(words)] + 1
        else:
            dictionary[str(words)] = 1

    final_json = json.dumps(dictionary,indent = 2)
    s3Upload.Object(Upload_bucket, json_file_name[0]+ "ne.txt").put(Body = (final_json))