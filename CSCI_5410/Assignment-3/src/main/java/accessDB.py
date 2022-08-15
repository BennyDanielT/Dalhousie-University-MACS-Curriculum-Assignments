import json
import boto3
import urllib.parse
import re
from datetime import datetime


def lambda_handler(event,context):

    dynamoDB_table = boto3.resource('dynamodb').Table('Assignment_3_Entities')
    s3Client = boto3.client("s3")
    bucket_name = event['Records'][0]['s3']['bucket']['name']
    key = urllib.parse.unquote_plus(event['Records'][0]['s3']['object']['key'], encoding='utf-8')
    file_content = s3Client.get_object(Bucket=bucket_name, Key=key)['Body'].read().decode("utf-8")
    parsed_object = json.loads(file_content)

    for key,value in parsed_object.items():
        dynamoDB_table.put_item(Item={'NamedEntity': key,'Frequency': value, 'TimeStamp of Entry' : datetime.now().isoformat()})