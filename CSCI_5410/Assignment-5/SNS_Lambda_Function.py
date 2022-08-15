import boto3

def lambda_handler(event, context):

	#sns client connection
    sns_client = boto3.client('sns')
    sns_arn = 'arn:aws:sns:us-east-1:927240965425:halifaxCars'

    body = event['Records'][0]['body']
    attributes = event['Records'][0]['messageAttributes']['Car']['stringValue']
    sub = 'Congratulations for your {} booking'.format(attributes)

    response = sns_client.publish(TopicArn=sns_arn, Message=body, Subject=sub)
