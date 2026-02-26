Realizado por Michael Portilla pata pruebas cargo Automatizador QA para TCS

Instrucciones para ejecución: 

=========================================================================================
Descripción:

Pruebas E2E (UI)

- Flujo completo de compra: selección de productos, adición al carrito y checkout
- Pruebas de consumo y response 

Pruebas de API

- Registro de usuarios (signup)
- Inicio de sesión (login)
- Validación de casos exitosos y de error

=========================================================================================

Tecnologías Utilizadas:

Java 17.0.11
Selenium WebDriver 4.27.0 - Automatización de UI
Karate 1.5.1 - Pruebas de API
TestNG 7.10.2- Framework de pruebas
WebDriverManager 5.9.2 - Gestión de drivers
Logback	1.4.14 - Logging
Healenium 3.5.8 - Self-healing de elementos
Apache Maven 3.9.9 Gestión de dependencias

=========================================================================================

Estructura del Proyecto:

selenium-java/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/tcs/qa/
│   │           ├── base/
│   │           │   ├── BasePage.java
│   │           │   └── BaseTest.java
│   │           ├── config/
│   │           │   ├── ConfigReader.java
│   │           │   └── DriverManager.java
│   │           ├── pages/
│   │           │   └── StorePage.java
│   │           └── utils/
│   └── test/
│       ├── java/
│       │   └── com/tcs/qa/
│       │       ├── data/
│       │       │   └── TestData.java
│       │       ├── tests/
│       │       │   └── Ejercicio1E2ETest.java
│       │       └── apitests/
│       │           └── ApiTests.java
│       └── resources/
│           ├── config.properties
│           ├── logback.xml
│           ├── testng.xml
│           └── features/
│               └── EjercicioApis.feature
├── evidenciasTest/
├── target/
└── pom.xml

=========================================================================================

Prerrequisitos

Software Necesario
1. Java JDK 17 o superior
- Descargar JDK 17
- Verificar instalación: java -version

2. Apache Maven 3.8+
- Descargar Maven
- Verificar instalación: mvn -version

3. Git 
- Descargar Git

4. IDE Recomendado: IntelliJ IDEA o Eclipse

=========================================================================================

Variables de Entorno:

# Windows
JAVA_HOME = C:\Program Files\Java\jdk-17
MAVEN_HOME = C:\apache-maven-3.8.x
PATH = %JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

# Linux/Mac
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export MAVEN_HOME=/opt/apache-maven-3.8.x
export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

=========================================================================================

Configurar Archivo de Propiedades:

src/test/resources/config.properties:

# Configuración del navegador
browser=chrome
headless=false
window.maximize=true

# Timeouts (segundos)
timeout.implicit=10
timeout.explicit=15
timeout.pageLoad=30

# URL base
base.url=https://www.demoblaze.com/

=========================================================================================

Descargar Dependencias

mvn dependency:resolve

=========================================================================================

Ejecución de Pruebas:

1. Abrir el proyecto en el IDE
2. Navegar a src/test/java/com/tcs/qa/tests/
3. Hacer clic derecho sobre Ejercicio1E2ETest
4. Seleccionar Run 'Ejercicio1E2ETest' para flujo de compra en blazemeter.
5. Para ejecutar los casos de prueba de Apis:
- Crear un nuevo usuario exitosamente: 'Ejercicio2ApisSignupSuccess'
- Intento de crear un usuario que ya existe: 'Ejercicio2ApisSingupFail'
- Iniciar sesión con usuario incorrectos y password correcto: 'Ejercicio2ApisLoginNotExist'
- Iniciar sesión con usuario correcto y password incorrecto: 'Ejercicio2ApisLoginWrongPassword'
- Iniciar sesión con usuario y password correctos: 'Ejercicio2ApisLoginSuccess'

=========================================================================================

Reportes y Evidencias

Reportes Karate (API)
- Ruta: target/karate-reports/karate-summary.html
- Abrir en navegador para ver resultados detallados.

Evidencias UI
- Ruta: ./evidenciasTest/
- Capturas automáticas en cada paso con formato: HH-mm-ss.png
- Logs detallados en consola

Logs de Ejecución
- Configuración en logback.xml
- timeout.explicit: INFO (general), DEBUG (código propio)

=========================================================================================

Verificación de Ejecución Exitosa:

=====================================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
=====================================================


Resultado Esperado - API Tests:

features:     1 | passed:     1 | failed: 0
scenarios:    5 | passed:     5 | failed: 0


=========================================================================================

Notas Adicionales:

Tags Disponibles (Karate)
- @signup-success - Registro exitoso
- @signup-fail - Registro usuario existente
- @login-success - Login exitoso
- @login-user-not-exist - Login usuario no existe
- @login-Wrong-password - Login contraseña incorrecta


Data Providers Disponibles
- @datosPalceHolder - Datos completos para compra

=========================================================================================



