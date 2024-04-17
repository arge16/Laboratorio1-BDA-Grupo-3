// http-common.js

const baseURL = 'https://6620338e3bf790e070af44b2.mockapi.io/'

export async function fetchData(endpoint) {
  try {
    const response = await fetch(`${baseURL}${endpoint}`)
    if (!response.ok) {
      throw new Error('Error al obtener los datos')
    }
    return await response.json()
  } catch (error) {
    console.error('Error:', error)
    throw error
  }
}

export async function postData(endpoint, data) {
  try {
    const response = await fetch(`${baseURL}${endpoint}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    if (!response.ok) {
      throw new Error('Error al enviar los datos')
    }
    return await response.json()
  } catch (error) {
    console.error('Error:', error)
    throw error
  }
}
