import React, { Component } from 'react'
import {
  Text,
  View,
  TextInput,
  StyleSheet,
  Button,
  TouchableOpacity,
} from "react-native";

export default class NewProduct extends Component {

    addProduct = () => {

    }

    render() {
      return(
        <View style={styles.container}>
          <TextInput style={styles.input} placeholder={"Product name"}></TextInput>
          <TextInput style={styles.input} placeholder={"Product description"}></TextInput>
          <TextInput style={styles.input} placeholder={"Date (DD/MM/YYYY) format"}></TextInput>
          <TextInput style={styles.input} placeholder={"Bar code"}></TextInput>
          <TouchableOpacity style={styles.addButton}>
              <Text style={styles.addProductText}>Add new product</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.addButton}>
              <Text style={styles.addProductText}>Add by barcode</Text>
          </TouchableOpacity>
        </View> 
      );
    };
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#8588A4",
    padding: 30,
    alignItems: "center",
  },
  input: {
    paddingVertical: 15,
    paddingHorizontal: 15,
    backgroundColor: "#FFF",
    borderRadius: 60,
    borderColor: "#C0C0C0",
    borderWidth: 1,
    width: 250,
  },
  addProductText: {
    color:'#fff',
    textAlign:'center',
    paddingLeft : 10,
    paddingRight : 10,
  },
  addButton: {
    width: 250,
    height: 60,
    backgroundColor: "#1E6738",
    borderRadius: 60,
    justifyContent: "center",
    alignItems: "center",
    borderColor: "#C0C0C0",
    borderWidth: 1,
  },
});