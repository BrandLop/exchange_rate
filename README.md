# Currency Exchange App 💱

**Currency Exchange App** es una aplicación en Java que permite a los usuarios realizar conversiones entre diferentes monedas utilizando ExchangeRate-API.

---

## 🛠️ Características

- Selección de moneda de origen y destino.
- Conversión de montos ingresados por el usuario.
- Cálculo de la conversión en tiempo real mediante la API [ExchangeRate-API](https://www.exchangerate-api.com/).
- Interfaz basada en consola, intuitiva y fácil de usar.

---

## 🚀 Requisitos del sistema

- **Java**: JDK 11 o superior.
- Conexión a Internet.
- Una cuenta activa en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una API Key.

---

## 📦 Instalación

1. **Clona este repositorio**:
    ```bash
    git clone https://github.com/tuusuario/currency-exchange-app.git
    cd currency-exchange-app
    ```

2. **Configura tu API Key**:
    1. Obtén tu API Key en [ExchangeRate-API](https://www.exchangerate-api.com/).
    2. Crea un archivo `.env` en el directorio raíz del proyecto.
    3. Define las siguientes variables en el archivo `.env`:
     ```plaintext
     EXCHANGE_RATE_API_KEY=tu_api_key
     ```
    4. Asegúrate de no subir este archivo al repositorio. Ya está incluido en `.gitignore`.

3. **Compila el proyecto**:
    ```bash
    javac Main.java
    ```

4. **Ejecuta la aplicación**:
    ```bash
    java Main
    ```

---

## 🖥️ Uso

1. **Selecciona las monedas**: 
   - Elige la moneda de origen y destino de una lista de opciones.

2. **Introduce el monto**: 
   - Escribe la cantidad que deseas convertir en la moneda de origen.

3. **Recibe el resultado**: 
   - La aplicación mostrará el monto equivalente en la moneda de destino.

### Ejemplo en consola:
```plaintext
-------------------------------------------------
Seleccione la divisa de origen:
1. ARS - Peso argentino
2. BOB - Boliviano boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
Ingrese el número correspondiente: 6
-------------------------------------------------
Seleccione la divisa de destino:
1. ARS - Peso argentino
2. BOB - Boliviano boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
Ingrese el número correspondiente: 1
-------------------------------------------------
Ingrese la cantidad en USD: 100
-------------------------------------------------
100.0 USD son 28350.0 ARS
```

## 📂 Estructura del proyecto

```plaintext
exchange_rate/src/
├── Main.java             # Archivo principal de ejecución
├── ExchangeRateService.java # Servicio para consumir la API de tasas de cambio
├── ExchangeRate.java     # Modelo para mapear la respuesta de la API
└── README.md             # Documentación del proyecto
```