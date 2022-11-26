from flask import Flask
from flask import Response
import sys

app = Flask(__name__)

@app.route("/")
def hello():
    resp = Response('{ "message" : "Servicio corriendo. Versión Python: ' + sys.version + '"}')
    resp.headers['Content-Type'] = 'application/json'
    return resp