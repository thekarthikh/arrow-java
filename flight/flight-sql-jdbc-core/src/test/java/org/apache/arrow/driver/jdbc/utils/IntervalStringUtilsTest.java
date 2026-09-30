/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.arrow.driver.jdbc.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Period;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class IntervalStringUtilsTest {

  @Test
  void formatsDigitsWithRootLocale() {
    Locale previous = Locale.getDefault();
    try {
      Locale.setDefault(Locale.forLanguageTag("ar-EG"));

      assertEquals("+021-02", IntervalStringUtils.formatIntervalYear(Period.ofYears(21).plusMonths(2)));
      assertEquals(
          "+021 02:03:04.005",
          IntervalStringUtils.formatIntervalDay(
              Duration.ofDays(21).plusHours(2).plusMinutes(3).plusSeconds(4).plusMillis(5)));
    } finally {
      Locale.setDefault(previous);
    }
  }
}
