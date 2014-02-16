/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2008-2014 Christian Scheiblich
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 * This file is part of JWave.
 *
 * @author Christian Scheiblich
 * @date 23.05.2008 17:42:23
 * cscheiblich@gmail.com
 */
package math.jwave.transforms.wavelets;

/**
 * Ingrid Daubechies' orthonormal wavelet of 14 coefficients and the scales;
 * normed, due to ||*||2 - euclidean norm.
 * 
 * @author Christian Scheiblich
 * @date 16.02.2014 00:26:36
 */
public class Daubechies07 extends Wavelet {

  /**
   * Already orthonormal coefficients taken from Filip Wasilewski's webpage
   * http://wavelets.pybytes.com/wavelet/db7/ Thanks!
   * 
   * @author Christian Scheiblich
   * @date 16.02.2014 00:26:36
   */
  public Daubechies07( ) {

    _transformWavelength = 2; // minimal wavelength of input signal

    _motherWavelength = 14; // wavelength of mother wavelet

    _scalingDeCom = new double[ _motherWavelength ];
    _scalingDeCom[ 0 ] = 0.0003537138000010399;
    _scalingDeCom[ 1 ] = -0.0018016407039998328;
    _scalingDeCom[ 2 ] = 0.00042957797300470274;
    _scalingDeCom[ 3 ] = 0.012550998556013784;
    _scalingDeCom[ 4 ] = -0.01657454163101562;
    _scalingDeCom[ 5 ] = -0.03802993693503463;
    _scalingDeCom[ 6 ] = 0.0806126091510659;
    _scalingDeCom[ 7 ] = 0.07130921926705004;
    _scalingDeCom[ 8 ] = -0.22403618499416572;
    _scalingDeCom[ 9 ] = -0.14390600392910627;
    _scalingDeCom[ 10 ] = 0.4697822874053586;
    _scalingDeCom[ 11 ] = 0.7291320908465551;
    _scalingDeCom[ 12 ] = 0.39653931948230575;
    _scalingDeCom[ 13 ] = 0.07785205408506236;

    // building wavelet as orthogonal (orthonormal) space from
    // scaling coefficients (low pass filter). Have a look into
    // Alfred Haar's wavelet or the Daubechie Wavelet with 2
    // vanishing moments for understanding what is done here. ;-)
    _waveletDeCom = new double[ _motherWavelength ];
    for( int i = 0; i < _motherWavelength; i++ )
      if( i % 2 == 0 )
        _waveletDeCom[ i ] = _scalingDeCom[ ( _motherWavelength - 1 ) - i ];
      else
        _waveletDeCom[ i ] = -_scalingDeCom[ ( _motherWavelength - 1 ) - i ];

    // Copy to reconstruction filters due to orthogonality (orthonormality)!
    _scalingReCon = new double[ _motherWavelength ];
    _waveletReCon = new double[ _motherWavelength ];
    for( int i = 0; i < _motherWavelength; i++ ) {

      _scalingReCon[ i ] = _scalingDeCom[ i ];
      _waveletReCon[ i ] = _waveletDeCom[ i ];

    } // i

  } // Daubechies07

} // Daubechies07
