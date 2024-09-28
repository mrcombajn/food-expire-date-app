import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import NewProductScreen from './components/NewProductScreen'
import HomeScreen from './components/HomeScreen.js'

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="New Product" component={NewProductScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};
