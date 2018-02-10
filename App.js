/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  requireNativeComponent,
} from 'react-native';

const NativeView = requireNativeComponent('NativeView', null);

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
      <NativeView style={{ flex: 1 }} />
    );
  }
}
