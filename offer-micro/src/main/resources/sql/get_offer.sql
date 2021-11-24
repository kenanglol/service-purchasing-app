SELECT ff.offer_id    AS offerID,
       ff.customer_id AS customerID,
       ff.provider_id AS serviceProviderID,
       ff.advert_id   AS advertID,
       ff.conditions  AS freeText,
       ff.status      AS serviceStatus,
       ff.session     AS session
FROM Offer ff WHERE ff.provider_id = ?1 AND ff.session = ?2