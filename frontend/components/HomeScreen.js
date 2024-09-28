import React, {Component, useState, useEffect} from 'react'
import {
  Text,
  View,
  TextInput,
  StyleSheet,
  ScrollView,
  Button,
  TouchableOpacity,
} from "react-native";
import axios from 'axios'
import Product from './Product.js'

export default function HomeScreen(props) {
  const [products, setProducts] = React.useState([]);

   const getProducts = () => {
       axios.get('http://10.0.2.2:8080/product')
             .then(function (response) {
                  setProducts(response.data)
             })
             .catch(function (error) {
               console.log(error.response.data)
             })
   }

   useEffect(() => {
     getProducts()
   }, [])

  return(    
    <View style={styles.container}>
      <View>
        <ScrollView
          contentContainerStyle={{
            flexGrow: 1,
          }}
        >
        <View style={styles.productsWrapper}>
            <View style={styles.items}>
              {products.map((item, index) => {
                return (
                  <TouchableOpacity
                    key={index}
                  >
                    <Product data={item} />
                  </TouchableOpacity>
                );
              })}
            </View>
        </View>
        </ScrollView>
      </View>
      <View style={styles.snackBar}>
        <TouchableOpacity onPress={() => props.navigation.navigate("New Product")}>
          <View style={styles.addWrapper}>
            <Text style={styles.addText}>+</Text>
          </View>
        </TouchableOpacity>
        <View style={styles.addWrapper}>
            <Text style={styles.addText}>+</Text>
          </View>
          <View style={styles.addWrapper}>
            <Text style={styles.addText}>+</Text>
          </View>
      </View>
    </View>
  );  
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#E8EAED',
  },
  productsWrapper: {
    paddingTop: 80,
    paddingHorizontal: 20,
  },
  items: {
    marginTop: 30,
    width: '100%',
  },
  snackBar: {
    position: "absolute",
    bottom: 20,
    width: "100%",
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "flex-end",
  },
  addWrapper: {
    width: 60,
    height: 60,
    bottom: 5,
    right: 5,
    backgroundColor: '#32a852',
    borderRadius: 60,
    justifyContent: 'center',
    alignItems: 'center',
    borderColor: '#069C31',
    borderWidth: 1,
  },
  addText: {
      color: '#ebf7ee',
  },
});