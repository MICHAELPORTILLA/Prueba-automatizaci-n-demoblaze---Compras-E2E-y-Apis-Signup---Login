Feature: Pruebas de Registro (Signup) e Inicio de Sesión (Login) en DemoBlaze

  Background:
    * url 'https://api.demoblaze.com/'
    * header Content-Type = 'application/json'
    * def randomString =
    """
    function(length) {
      var text = "";
      var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      for (var i = 0; i < length; i++) {
        text += possible.charAt(Math.floor(Math.random() * possible.length));
      }
      return text;
    }
    """
  # --- ESCENARIOS DE (SIGNUP) ---

  @signup-success
  Scenario: Crear un nuevo usuario exitosamente
    * def user = 'michaelportilla' + randomString(5)
    * def pass = 'cGFzc3dvcmQ='
    * def requestBody = { username: '#(user)', password: '#(pass)' }

    Given path 'signup'
    And request requestBody
    When method POST
    Then status 200
    * print 'RESPUESTA COMPLETA:', response

  @signup-fail
  Scenario: Intento de crear un usuario que ya existe
    * def user = 'michaelportilla'
    * def pass = 'cGFzc3dvcmQ='
    * def requestBody = { username: '#(user)', password: '#(pass)' }

    Given path 'signup'
    And request requestBody
    When method POST
    Then status 200
    And match response == { "errorMessage": "This user already exist." }
    * print 'RESPUESTA COMPLETA:', response

  # --- ESCENARIOS DE (LOGIN) ---

  @login-user-not-exist
  Scenario: Iniciar sesión con usuario incorrectos y password correcto
    * def user = 'michaelportilla1'
    * def pass = 'cGFzc3dvcmQ='
    * def requestBody = { username: '#(user)', password: '#(pass)' }

    Given path 'login'
    And request requestBody
    When method POST
    Then status 200
#    * print 'RESPUESTA COMPLETA:', response
    And match response == {"errorMessage": "User does not exist."}

  @login-Wrong-password
  Scenario: Iniciar sesión con usuario correcto y password incorrecto
    * def user = 'michaelportilla'
    * def pass = 'cGFzc3dvccQ='
    * def requestBody = { username: '#(user)', password: '#(pass)' }

    Given path 'login'
    And request requestBody
    When method POST
    Then status 200
    And match response == {"errorMessage": "Wrong password."}
    * print 'RESPUESTA COMPLETA:', response

  @login-success
  Scenario: Iniciar sesión con usuario y password correctos
    * def user = 'michaelportilla'
    * def pass = 'cGFzc3dvcmQ='
    * def requestBody = { username: '#(user)', password: '#(pass)' }

    Given path 'login'
    And request requestBody
    When method post
    Then status 200
    And match response contains 'Auth_token:'