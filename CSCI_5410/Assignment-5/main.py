from Credentials import Credentials
import random
import datetime
import boto3
import json
def simulate_messages():
    cred = Credentials();
    access_key = cred.aws_access_key_id
    secret_key = cred.aws_secret_access_key
    token = cred.aws_session_token
    url = cred.AWS_SQS_URL
    # print(access_key)

    AWS_Queue_Service = boto3.client('sqs', aws_access_key_id=access_key, aws_secret_access_key=secret_key, aws_session_token=token,
                       region_name='us-east-1')

    message_queue = []

    with open('Cars.json', 'r') as f:
        cars_JSON = json.load(f)

    # print(cars_JSON)
    # print(cars_JSON['Cars'][2])
    list_of_cars = cars_JSON['Cars']

    for vehicles in list_of_cars:
        # print(vehicles)
        # print(vehicles['Car']['StringValue'])
        attributes = vehicles

        message_body = f"Hey there Alice!, A customer has booked one of our {vehicles['Car']['StringValue']}s on {vehicles['Date']['StringValue']}. Please deliver it!"
        message_queue.append({'message_attributes': attributes, 'message_body': message_body})
        print(f'message_attributes: {attributes}, message_body: {message_body}')

    for message in message_queue:
        response = AWS_Queue_Service.send_message(QueueUrl=url, DelaySeconds=10,
                                                  MessageAttributes=message.get('message_attributes'),
                                                  MessageBody=message.get('message_body'))
        print(response)


if __name__ == '__main__':
    simulate_messages()



